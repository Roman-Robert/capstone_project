package com.epam.racecup.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "organizer")
@DiscriminatorValue("organizer")
public class OrganizerEntity {

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private UserEntity user;

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "mobile_phone")
    private String mobilePhone;
}
