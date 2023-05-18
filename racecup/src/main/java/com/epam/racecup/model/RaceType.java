package com.epam.racecup.model;

public enum RaceType {
    ROAD("Road"),
    GRAVEL("Gravel"),
    CROSS_COUNTRY("CrossCountry");

    private final String raceType;

    private RaceType(String raceType) {
        this.raceType = raceType;
    }

    public String getDisplayRaceType() {
        return raceType;
    }
}


