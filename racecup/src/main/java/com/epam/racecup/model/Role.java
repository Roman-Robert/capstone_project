package com.epam.racecup.model;

public enum Role {
    ROLE_USER("User"),
    ROLE_ATHLETE("Athlete"),
    ROLE_ORGANIZER("Organizer"),
    ROLE_ADMIN("Admin");

    private final String role;

    private Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}