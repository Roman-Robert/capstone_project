package com.epam.racecup.mapper;

import com.epam.racecup.model.dto.ResultDTO;
import com.epam.racecup.model.entity.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultMapper {
    private final AthleteMapper athleteMapper;
    private final RaceMapper raceMapper;

    @Autowired
    public ResultMapper(AthleteMapper mapper, RaceMapper raceMapper) {
        this.athleteMapper = mapper;
        this.raceMapper = raceMapper;
    }

    public ResultDTO entityToDto(ResultEntity resultEntity) {

        return ResultDTO.builder()
                .resultId(resultEntity.getResultId())
                .athlete(athleteMapper.entityToDto(resultEntity.getAthlete()))
                .race(raceMapper.entityToDto(resultEntity.getRace()))
                .transitTime(resultEntity.getTransitTime())
                .resultStatus(resultEntity.getResultStatus())
                .build();
    }

    public ResultEntity dtoToEntity(ResultDTO resultDTO) {
        return ResultEntity.builder()
                .resultId(resultDTO.getResultId())
                .athlete(athleteMapper.dtoToEntity(resultDTO.getAthlete()))
                .race(raceMapper.dtoToEntity(resultDTO.getRace()))
                .transitTime(resultDTO.getTransitTime())
                .resultStatus(resultDTO.getResultStatus())
                .build();
    }
}
