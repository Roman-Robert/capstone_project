package com.epam.racecup.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
@Entity
@Data
@Table(name="race_result")
public class RaceResult {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resultId;
    @Column(name = "athlete_id")
    private int athleteId;
    @Column(name="race_id")
    private int raceId;
    @Column(name = "transit_time", columnDefinition = "TIME")
    private Time transitTime;
    @Column(name="status")
    private Status status;
}
