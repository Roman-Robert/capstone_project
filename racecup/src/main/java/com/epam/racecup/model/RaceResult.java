package com.epam.racecup.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
@Entity
@Data
@Table(name="race_result")
public class RaceResult {

    @Id
    @Column(name="result_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long resultId;

    @Column(name = "athlete_id")
    private long athleteId;

    @Column(name="race_id")
    private long raceId;

    @Column(name = "transit_time", columnDefinition = "TIME")
    private Time transitTime;

    @Column(name="status")
    private ResultStatus resultStatus;
}
