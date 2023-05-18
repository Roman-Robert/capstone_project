package com.epam.racecup.service;

import com.epam.racecup.dao.repository.ResultRepository;
import com.epam.racecup.mapper.ResultMapper;
import com.epam.racecup.model.dto.ResultDTO;
import com.epam.racecup.model.entity.ResultEntity;
import com.epam.racecup.util.AgeGroupUtil;
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

    @Autowired
    public ResultService(ResultRepository resultRepository, ResultMapper mapper) {
        this.resultRepository = resultRepository;
        this.mapper = mapper;
    }


    public Page<ResultDTO> getRaceResultsByRaceId(Long race_id, Pageable pageable) {
        List<ResultEntity> resultEntities = resultRepository.findByRaceId(race_id);
        List<ResultDTO> resultDTOs = new ArrayList<>();

        //Сортировка по времени
        resultEntities.sort(Comparator.comparing(ResultEntity::getTransitTime));

        for (ResultEntity resultEntity : resultEntities) {
            //мапим в дто
            ResultDTO resultDTO = mapper.entityToDto(resultEntity);
            //присваиваем место
            resultDTO.setPlace(resultEntities.indexOf(resultEntity) + 1);
            //присваиваем группу
            resultDTO.setGroup(AgeGroupUtil.getGroup(resultEntity.getAthlete(), resultEntity.getRace()));
            //кладем в лист
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

        // Создаем объект Page<ResultDTO> с использованием информации о пагинации
        return new PageImpl<>(pageResults, pageable, resultDTOs.size());
    }

    public List<ResultDTO> getRaceResultsByRaceId(Long race_id) {
        List<ResultEntity> resultEntities = resultRepository.findByRaceId(race_id);
        return resultEntities
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    public void saveResult(ResultEntity raceResult) {
        resultRepository.save(raceResult);
    }
}

