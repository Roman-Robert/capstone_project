package com.epam.racecup.models;

public class Admin extends User{

    private int id;
    private int user_id;

    public Admin() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", user_id=" + user_id +
                '}';
    }
}
