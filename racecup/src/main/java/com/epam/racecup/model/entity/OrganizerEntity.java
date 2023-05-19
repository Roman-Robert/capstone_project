package com.epam.racecup.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "organizer")
@DiscriminatorValue("organizer")
public class OrganizerEntity {

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private UserEntity user;

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "mobile_phone")
    private String mobilePhone;
}
