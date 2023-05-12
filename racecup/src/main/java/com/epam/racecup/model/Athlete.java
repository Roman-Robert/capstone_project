package com.epam.racecup.model;

import java.util.Date;

//@Entity
//@Table(name = "athlete")
public class Athlete extends User {

//    @Column(name = "birthday")
    private Date birthday;
//    @Column(name = "gender")
//    @Enumerated(EnumType.STRING)
    private Gender gender;
//    @Column(name = "country")
    private String country;
//    @Column(name = "city")
    private String city;
//    @Column(name = "team")
    private String team;


    public Athlete() {
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
