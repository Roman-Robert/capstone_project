package com.epam.racecup.model;

import javax.persistence.*;
import java.sql.Time;
@Entity
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

    public RaceResult() {
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(int athleteId) {
        this.athleteId = athleteId;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public Time getTransitTime() {
        return transitTime;
    }

    public void setTransitTime(Time transitTime) {
        this.transitTime = transitTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RaceResult{" +
                "resultId=" + resultId +
                ", athletId=" + athleteId +
                ", raceId=" + raceId +
                ", transitTime=" + transitTime +
                ", status=" + status +
                '}';
    }
}
