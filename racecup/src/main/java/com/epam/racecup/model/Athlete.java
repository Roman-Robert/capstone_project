package com.epam.racecup.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "athlete")
public class Athlete implements Serializable {

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
