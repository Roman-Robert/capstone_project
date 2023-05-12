package com.epam.racecup.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "race")
public class Race {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "race_type")
    private RaceType raceType;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "distance_km")
    private Double distanceKm;

    @Column(name = "date")
    private Date date;


    @Column(name = "info")
    private String info;

    @Column(name = "organizer_id")
    private long organizerId;

    @Column(name = "is_actual")
    private int isActual;
    
}
