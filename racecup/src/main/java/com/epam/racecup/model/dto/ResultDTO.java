package com.epam.racecup.model.dto;

import com.epam.racecup.model.ResultStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ResultDTO {
    private long resultId;
    private Time transitTime;
    private ResultStatus resultStatus;
    private AthleteDTO athlete;
    private RaceDTO race;

    private long place;
    private String group;
    private int rating;
}
