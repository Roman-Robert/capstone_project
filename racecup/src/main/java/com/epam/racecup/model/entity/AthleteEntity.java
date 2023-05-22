package com.epam.racecup.model.entity;

import com.epam.racecup.model.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
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
