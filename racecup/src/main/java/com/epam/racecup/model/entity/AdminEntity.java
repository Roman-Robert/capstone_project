package com.epam.racecup.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "admin")
@DiscriminatorValue("admin")
public class AdminEntity {

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private UserEntity user;

    @Id
    @Column(name = "id")
    private long id;
}