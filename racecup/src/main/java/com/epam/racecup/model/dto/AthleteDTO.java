package com.epam.racecup.model.dto;

import com.epam.racecup.model.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class AthleteDTO {
    private UserDTO user;
    private long id;
    private Date birthday;
    private Gender gender;
    private String country;
    private String city;
    private String team;

    //fields to calculation
    private int place;
    private String group;

}
