package com.epam.racecup.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "athlete")
@DiscriminatorValue("athlete")
public class Athlete {

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "birthday")
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

    @ManyToMany
    @JoinTable(name = "race_result",
            joinColumns = @JoinColumn(name = "athlete_id"),
            inverseJoinColumns = @JoinColumn(name = "race_id"))
    private List<Race> races;
}
