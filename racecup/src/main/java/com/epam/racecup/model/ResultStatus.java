package com.epam.racecup.model;

public enum ResultStatus {
    DNS("DNS"),
    DNF("DNF"),
    DSQ("DSQ");

    private final String value;

    ResultStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
