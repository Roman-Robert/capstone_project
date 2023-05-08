package com.epam.racecup.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "race")
public class Race {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "race_type")
    private RaceType raceType;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "distanceKm")
    private Double distanceKm;

    @Column(name = "date")
    private Date date;


    @Column(name = "info")
    private String info;

    //Реализовать применение id организатора
    @Column(name = "organizer_id")
    private int organizerId;

    public Race() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RaceType getRaceType() {
        return raceType;
    }

    public void setRaceType(RaceType raceType) {
        this.raceType = raceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(Double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(int organizerId) {
        this.organizerId = organizerId;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", raceType=" + raceType +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", distanceKM=" + distanceKm +
                ", dateTime=" + date +
                ", info='" + info + '\'' +
                ", organizerId=" + organizerId +
                '}';
    }
}
