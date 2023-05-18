package com.epam.racecup.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "admin")
@DiscriminatorValue("admin")
public class Admin {

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;

    @Id
    @Column(name = "id")
    private long id;
}