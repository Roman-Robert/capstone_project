package com.epam.racecup.service;

import com.epam.racecup.dao.repository.ResultRepository;
import com.epam.racecup.mapper.ResultMapper;
import com.epam.racecup.model.ResultStatus;
import com.epam.racecup.model.dto.ResultDTO;
import com.epam.racecup.model.entity.RaceEntity;
import com.epam.racecup.model.entity.ResultEntity;
import com.epam.racecup.util.AgeGroupUtil;
import com.epam.racecup.util.RatingCalculatorUtil;
import com.epam.racecup.util.TimeComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    public Page<ResultDTO> getAllResults(Pageable pageable) {
        List<ResultDTO> resultsList = getAllResultsListWithPlaces();

        for (ResultDTO result : resultsList) {
            int place = (int) result.getPlace();
            result.setRating(ratingCalculator.calculateRating(place));
        }

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<ResultDTO> pageResults;

        if (resultsList.size() < startItem) {
            pageResults = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, resultsList.size());
            pageResults = resultsList.subList(startItem, toIndex);
        }

        return new PageImpl<>(pageResults, pageable, resultsList.size());
    }

    public Page<ResultDTO> getRaceResultsByRaceId(Long raceId, Pageable pageable) {
        List<ResultDTO> resultDTOs = getRaceResultsByRaceId(raceId);

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


    //Method without pagination to set results of race
    public List<ResultDTO> getRaceResultsByRaceId(Long race_id) {
        List<ResultEntity> resultEntities = resultRepository.findByRaceId(race_id);
        List<ResultDTO> resultDTOs = new ArrayList<>();

        sortResultListByTransitTime(resultEntities);

        for (ResultEntity resultEntity : resultEntities) {
            ResultDTO resultDTO = mapper.entityToDto(resultEntity);

            resultDTO.setPlace(resultEntities.indexOf(resultEntity) + 1);
            resultDTO.setGroup(AgeGroupUtil.getGroup(resultEntity.getAthlete(), resultEntity.getRace()));
            resultDTOs.add(resultDTO);
        }

        return resultDTOs;
    }

    public void saveResult(ResultDTO raceResult) {
        ResultStatus resultStatus = raceResult.getResultStatus();

        if (Arrays.asList(ResultStatus.values()).contains(resultStatus)) {
            raceResult.setTransitTime(null);
        }

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
            sortResultListByTransitTime(resultEntities);
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

    public void updateResult(List<ResultDTO> results) {
        for (ResultDTO result : results) {
            //getting result to update
            ResultDTO updatedResult = getResultById(result.getResultId());
            //updating status and transit time fields
            updatedResult.setResultStatus(result.getResultStatus());
            updatedResult.setTransitTime(result.getTransitTime());
            //saving updated result
            saveResult(updatedResult);
        }
    }

    public ResultDTO getResultById(long id) {
        return mapper.entityToDto(resultRepository.getOne(id));
    }

    public List<ResultEntity> sortResultListByTransitTime(List<ResultEntity> resultsList) {
        resultsList.sort(new TimeComparator());
        return resultsList;
    }
}

