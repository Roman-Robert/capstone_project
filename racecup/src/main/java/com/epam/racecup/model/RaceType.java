package com.epam.racecup.model;

public enum RaceType {
    ROAD("Road race"),
    GRAVEL("Gravel race"),
    CROSS_COUNTRY("CrossCountry race");

    private final String raceType;

    private RaceType(String raceType) {
        this.raceType=raceType;
    }

    public String getDisplayRaceType() {
        return raceType;
    }
}


