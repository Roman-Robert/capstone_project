package com.epam.racecup.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "athlete")
public class Athlete extends User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "birthday", columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "team")
    private String team;


    public Athlete() {
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

    @Override
    public String toString() {
        return "Athlete{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", team='" + team + '\'' +
                '}';
    }
}
