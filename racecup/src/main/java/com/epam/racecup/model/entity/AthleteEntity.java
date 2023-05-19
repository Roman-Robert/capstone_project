package com.epam.racecup.model.entity;

import com.epam.racecup.model.Gender;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "athlete")
@DiscriminatorValue("athlete")
public class AthleteEntity {

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private UserEntity user;

    @Id
    @Column(name = "id")
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

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "race_result",
            joinColumns = @JoinColumn(name = "athlete_id"),
            inverseJoinColumns = @JoinColumn(name = "race_id"))
    private List<RaceEntity> races;
}
