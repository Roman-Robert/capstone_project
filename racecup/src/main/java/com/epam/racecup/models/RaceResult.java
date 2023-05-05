package com.epam.racecup.models;

import java.sql.Time;

public class RaceResult {

    private int resultId;
    private int athletId;
    private int raceId;
    private Time transitTime;
    private Status status;

    public RaceResult() {
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getAthletId() {
        return athletId;
    }

    public void setAthletId(int athletId) {
        this.athletId = athletId;
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
                ", athletId=" + athletId +
                ", raceId=" + raceId +
                ", transitTime=" + transitTime +
                ", status=" + status +
                '}';
    }
}
