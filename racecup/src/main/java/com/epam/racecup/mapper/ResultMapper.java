package com.epam.racecup.mapper;

import com.epam.racecup.model.dto.ResultDTO;
import com.epam.racecup.model.entity.ResultEntity;
import org.springframework.stereotype.Component;

@Component
public class ResultMapper {

    public ResultDTO entityToDto(ResultEntity resultEntity) {

        return ResultDTO.builder()
                .resultId(resultEntity.getResultId())
                .athlete(resultEntity.getAthlete())
                .race(resultEntity.getRace())
                .transitTime(resultEntity.getTransitTime())
                .resultStatus(resultEntity.getResultStatus())
                .build();
    }

    public ResultEntity dtoToEntity(ResultDTO resultDTO) {
        return ResultEntity.builder()
                .resultId(resultDTO.getResultId())
                .athlete(resultDTO.getAthlete())
                .race(resultDTO.getRace())
                .transitTime(resultDTO.getTransitTime())
                .resultStatus(resultDTO.getResultStatus())
                .build();
    }
}
