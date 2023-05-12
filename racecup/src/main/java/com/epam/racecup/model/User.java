package com.epam.racecup.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    //Реализовать автозаполнение "1"
    @Column(name = "is_active")
    private int isActive;

    //Реализовать автозаполнение "user"
    @Column(name = "role")
    private String role;

    @OneToOne(mappedBy = "user")
    private Athlete athlete;
}