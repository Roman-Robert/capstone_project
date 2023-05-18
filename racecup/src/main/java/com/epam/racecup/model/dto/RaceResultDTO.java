package com.epam.racecup.model.dto;

import com.epam.racecup.model.entity.AthleteEntity;
import com.epam.racecup.model.entity.RaceEntity;
import com.epam.racecup.model.ResultStatus;
import lombok.Data;

import java.sql.Time;

@Data
public class RaceResultDTO {
    private long resultId;
    private Time transitTime;
    private ResultStatus resultStatus;
    private AthleteEntity athleteEntity;
    private RaceEntity raceEntity;

}
