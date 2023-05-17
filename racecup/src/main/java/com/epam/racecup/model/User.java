package com.epam.racecup.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    @NotEmpty(message = "Username should not be empty")
    @Size(min = 2, max = 15, message = "Username should be between 2 and 15 characters")
    private String username;

    @Column(name = "first_name")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 15, message = "Name should be between 2 and 15 characters")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "Last name should not be empty")
    @Size(min = 2, max = 15, message = "Last name should be between 2 and 15 characters")
    private String lastName;

    @Column(name = "email", unique = true)
    @NotEmpty
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Password should not be empty")
    @Column(name = "password")
    private String password;

    @Column(name = "is_active")
    private int isActive = 1;

    @Column(name = "role")
    private String role = Role.ROLE_USER.getRole();


    //////////////////////////////////////////////
    /////////Поля для связей
    @OneToOne(mappedBy = "user")
    private Athlete athlete;

    @OneToOne(mappedBy = "user")
    private Admin admin;

    @OneToOne(mappedBy = "user")
    private Organizer organizer;
}