package com.epam.racecup.model.entity;

import com.epam.racecup.model.RaceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "race")
public class RaceEntity {
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
    private long organizerId = 1;

    @Column(name = "is_actual")
    private int isActual = 1;

    @ManyToMany(mappedBy = "races", cascade = CascadeType.ALL)
    private List<AthleteEntity> athletes;
}