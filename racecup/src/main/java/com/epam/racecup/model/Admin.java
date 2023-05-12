package com.epam.racecup.model;

public class Admin extends User{
    private long user_id;

    public Admin() {
    }

    public long getUserId() {
        return user_id;
    }

    public void setUserId(long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "user_id=" + user_id +
                '}';
    }
}
