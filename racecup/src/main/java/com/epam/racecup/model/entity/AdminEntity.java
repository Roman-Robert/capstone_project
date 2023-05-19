package com.epam.racecup.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "admin")
@DiscriminatorValue("admin")
public class AdminEntity {

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private UserEntity user;

    @Id
    @Column(name = "id")
    private long id;
}