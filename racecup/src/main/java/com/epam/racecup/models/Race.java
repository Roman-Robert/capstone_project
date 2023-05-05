package com.epam.racecup.models;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name="race")
public class Race {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="race_type")
    @Enumerated(EnumType.STRING)
    private RaceType raceType;
    @Column(name="name")
    private String name;
    @Column(name="location")
    private String location;
    @Column(name="distance")
    private Double distanceKm;
    @Column(name="date_time")
    private LocalDateTime dateTime;
    @Column(name="info")
    private String info;
    @Column(name="organizer_id")
    private int organizerId;

    public Race() {}

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

    public Double getDistanceKM() {
        return distanceKm;
    }

    public void setDistanceKM(Double distanceKM) {
        this.distanceKm = distanceKM;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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
                ", dateTime=" + dateTime +
                ", info='" + info + '\'' +
                ", organizerId=" + organizerId +
                '}';
    }
}
