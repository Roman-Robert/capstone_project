package com.epam.racecup.model;

public enum Gender {
    MALE("M"),
    FEMALE("W");

    private String value;

    Gender(String value) {
        this.value=value;
    }

    @Override
    public String toString() {
        return value;
    }
}
