package com.epam.racecup.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "organizer")
@DiscriminatorValue("organizer")
public class Organizer {

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "mobile_phone")
    private String mobilePhone;
}
