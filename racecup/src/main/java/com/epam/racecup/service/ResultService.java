package com.epam.racecup.service;

import com.epam.racecup.dao.repository.ResultRepository;
import com.epam.racecup.mapper.ResultMapper;
import com.epam.racecup.model.dto.ResultDTO;
import com.epam.racecup.model.entity.RaceEntity;
import com.epam.racecup.model.entity.ResultEntity;
import com.epam.racecup.util.AgeGroupUtil;
import com.epam.racecup.util.RatingCalculatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultService {

    private final ResultRepository resultRepository;
    private final ResultMapper mapper;
    private final RatingCalculatorUtil ratingCalculator;

    @Autowired
    public ResultService(ResultRepository resultRepository, ResultMapper mapper, RatingCalculatorUtil ratingCalculator) {
        this.resultRepository = resultRepository;
        this.mapper = mapper;
        this.ratingCalculator = ratingCalculator;
    }

    public List<ResultDTO> getAllResults() {
        List<ResultDTO> resultsList = getAllResultsListWithPlaces();
        for (ResultDTO result : resultsList) {
            int place = (int) result.getPlace();
            result.setRating(ratingCalculator.calculateRating(place));
        }
        return resultsList;
    }

    public Page<ResultDTO> getRaceResultsByRaceId(Long race_id, Pageable pageable) {
        List<ResultEntity> resultEntities = resultRepository.findByRaceId(race_id);
        List<ResultDTO> resultDTOs = new ArrayList<>();

        //Sorting by transit time ASC
        try {
            resultEntities.sort(Comparator.nullsLast(Comparator.comparing(ResultEntity::getTransitTime)));
        } catch (NullPointerException e) {
            System.out.println("Error in comparator - null value of time!");
        }

        for (ResultEntity resultEntity : resultEntities) {
            ResultDTO resultDTO = mapper.entityToDto(resultEntity);

            resultDTO.setPlace(resultEntities.indexOf(resultEntity) + 1);
            resultDTO.setGroup(AgeGroupUtil.getGroup(resultEntity.getAthlete(), resultEntity.getRace()));
            resultDTOs.add(resultDTO);
        }

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<ResultDTO> pageResults;

        if (resultDTOs.size() < startItem) {
            pageResults = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, resultDTOs.size());
            pageResults = resultDTOs.subList(startItem, toIndex);
        }

        return new PageImpl<>(pageResults, pageable, resultDTOs.size());
    }


    //Method without pagination to set all results of race
    public List<ResultDTO> getRaceResultsByRaceId(Long race_id) {
        List<ResultEntity> resultEntities = resultRepository.findByRaceId(race_id);
        return resultEntities
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }


    //Method doesn't work
    public void saveResult(ResultDTO raceResult) {
        resultRepository.save(mapper.dtoToEntity(raceResult));
    }

    public List<ResultDTO> getRaceResultsByAthleteID(Long id) {
        List<ResultDTO> fullResultList = getAllResultsListWithPlaces();
        List<ResultDTO> athleteResultsList = new ArrayList<>();

        for (ResultDTO result : fullResultList) {
            if (result.getAthlete().getId() == id) {
                athleteResultsList.add(result);
            }
        }
        return athleteResultsList;
    }

    public List<ResultDTO> getAllResultsListWithPlaces() {
        List<ResultDTO> resultDTOs = new ArrayList<>();
        //List of all results
        List<ResultEntity> resultEntityList = resultRepository.findAll();
        //Getting list of unique race id
        List<Long> listRaceId = resultEntityList
                .stream()
                .map(ResultEntity::getRace)
                .map(RaceEntity::getId)
                .distinct()
                .collect(Collectors.toList());

        for (long raceId : listRaceId) {
            //getting list of results for each race id
            List<ResultEntity> resultEntities = resultRepository.findByRaceId(raceId);
            //comparing results by transit time
            try {
                resultEntities.sort(Comparator.nullsLast(Comparator.comparing(ResultEntity::getTransitTime)));
            } catch (NullPointerException e) {
                System.out.println("Error in comparator - null value of time!");
            }
            //Entity->DTO
            List<ResultDTO> resultDtoOneRace = resultEntities
                    .stream()
                    .map(mapper::entityToDto)
                    .collect(Collectors.toList());
            //assigning a place by index in the list of results
            for (ResultDTO resultDTO : resultDtoOneRace) {
                //Setting place in this race
                resultDTO.setPlace(resultDtoOneRace.indexOf(resultDTO) + 1);
                //Adding to exit list if athlete id equals parameter id
                resultDTOs.add(resultDTO);
            }
        }
        return resultDTOs;
    }

}

