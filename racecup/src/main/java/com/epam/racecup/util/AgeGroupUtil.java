package com.epam.racecup.util;

import com.epam.racecup.model.entity.AthleteEntity;

import java.sql.Date;

public class AgeGroupUtil {

    public static String getGroup(AthleteEntity athleteEntity, Date raceDate) {
        String group = athleteEntity.getGender().getValue();
        int age = athleteEntity.getBirthday().getYear() - raceDate.getYear();

        if (age >= 18 && age < 25) {
            group += "18";
        } else if (age >= 25 && age < 35) {
            group += "25";
        } else if (age >= 35 && age < 45) {
            group += "35";
        } else if (age >= 45) {
            group += "45+";
        }
        return group;
    }
}
