package com.epam.racecup.model;

public class Organizer extends User{

    private long user_id;
    private String mobilePhone;

    public Organizer() {}

    public long getUser_id() {
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
                "user_id=" + user_id +
                ", mobilePhone='" + mobilePhone + '\'' +
                '}';
    }
}
