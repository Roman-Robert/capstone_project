package com.epam.racecup.models;

public enum RaceType {
    ROAD,
    GRAVEL,
    CROSS_COUNTRY;

    public String toString() {
        switch (this) {
            case ROAD:
                return "Road";
            case GRAVEL:
                return "Gravel";
            case CROSS_COUNTRY:
                return "Cross Country";
        }
        return "";
    }
}


