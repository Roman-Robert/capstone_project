package com.epam.racecup.model.dto;

import com.epam.racecup.model.RaceType;
import lombok.*;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class RaceDTO {
    private long id;
    private RaceType raceType;
    private String name;
    private String location;
    private Double distanceKm;
    private Date date;
    private String info;
    //реализовать автозаполнение на айдишник админа
    private long organizerId;
    private int isActual;
}
