package com.epam.racecup.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Field can't be empty")
    @Column(name = "username")
    private String username;

    @NotEmpty(message = "Field can't be empty")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Field can't be empty")
    @Column(name = "last_name")
    private String lastName;

    @Email(message = "Email should be valid")
    @NotEmpty(message = "Field can't be empty")
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty(message = "Field can't be empty")
    @Column(name = "password")
    private String password;

    //Реализовать автозаполнение "1"
    @Column(name = "is_active")
    private int isActive;

    //Реализовать автозаполнение "user"
    @Column(name = "role")
    private String role;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", role='" + role + '\'' +
                '}';
    }
}