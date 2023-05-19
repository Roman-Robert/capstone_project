package com.epam.racecup.model.dto;

import com.epam.racecup.model.entity.AthleteEntity;
import com.epam.racecup.model.entity.RaceEntity;
import com.epam.racecup.model.ResultStatus;
import lombok.*;

import java.sql.Time;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ResultDTO {
    private long resultId;
    private Time transitTime;
    private ResultStatus resultStatus;
    private AthleteEntity athlete;
    private RaceEntity race;

    private long place;
    private String group;
}
