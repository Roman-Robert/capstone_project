package com.epam.racecup.model.dto;

import com.epam.racecup.model.RaceType;
import lombok.Data;

import java.sql.Date;

@Data
public class RaceDTO {
    private long id;
    private RaceType raceType;
    private String name;
    private String location;
    private Double distanceKm;
    private Date date;
    private String info;
    //реализовать автозаполнение на айдишник админа
    private long organizerId = 1;
    private int isActual = 1;
}
