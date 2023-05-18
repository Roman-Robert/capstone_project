package com.epam.racecup.model.dto;

import com.epam.racecup.model.Gender;
import com.epam.racecup.model.entity.UserEntity;
import lombok.Data;

import java.sql.Date;

@Data
public class AthleteDTO {
    private UserEntity userEntity;
    private long id;
    private Date birthday;
    private Gender gender;
    private String country;
    private String city;
    private String team;

    //-----------------
    private int place;
    private String group;

}
