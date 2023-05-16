package com.epam.racecup.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.util.List;

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

    @NotEmpty(message = "Race name should not be empty")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Location should not be empty")
    @Column(name = "location")
    private String location;

    @NotEmpty(message = "Distance should not be empty")
    @Min(value = 0, message = "Distance shold be greater then zero")
    @Column(name = "distance_km")
    private Double distanceKm;

    @NotEmpty(message = "Date should not be empty")
    @Column(name = "date")
    private Date date;

    @NotEmpty(message = "Info box should not be empty")
    @Column(name = "info")
    private String info;

    //реализовать автозаполнение на айдишник админа
    @Column(name = "organizer_id")
    private long organizerId = 1;

    @Column(name = "is_actual")
    private int isActual = 1;

    @ManyToMany(mappedBy = "races")
    private List<Athlete> athletes;
}
