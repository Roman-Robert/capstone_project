package com.epam.racecup.model;

public enum ResultStatus {
    DNS("DNS"),
    DNF("DNF"),
    DSQ("DSQ");

    private final String resultStatus;

    private ResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getValue() {
        return resultStatus;
    }
}