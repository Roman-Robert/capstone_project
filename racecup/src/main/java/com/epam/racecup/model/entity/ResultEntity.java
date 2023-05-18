package com.epam.racecup.model.entity;

import com.epam.racecup.model.ResultStatus;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "race_result")
public class ResultEntity {

    @Id
    @Column(name = "result_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long resultId;

    @Column(name = "transit_time", columnDefinition = "TIME")
    private Time transitTime;

    @Column(name = "status")
    private ResultStatus resultStatus;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private AthleteEntity athlete;

    @ManyToOne
    @JoinColumn(name = "race_id")
    private RaceEntity race;
}
