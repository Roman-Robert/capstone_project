package com.epam.racecup.model;

public class Organizer extends User{

    private int id;
    private int user_id;
    private String mobilePhone;

    public Organizer() {}

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

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", mobilePhone='" + mobilePhone + '\'' +
                '}';
    }
}
