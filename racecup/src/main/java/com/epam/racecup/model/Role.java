package com.epam.racecup.model;

public enum Role {
    USER("User"),
    ATHLETE("Athlete"),
    ADMIN("Administrator");

    private final String role;

    private Role(String role) {
        this.role=role;
    }

    public String getRole() {
        return role;
    }
}
