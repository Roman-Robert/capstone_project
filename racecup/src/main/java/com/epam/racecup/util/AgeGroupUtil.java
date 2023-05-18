package com.epam.racecup.util;

import com.epam.racecup.model.entity.AthleteEntity;
import com.epam.racecup.model.entity.RaceEntity;
import org.springframework.stereotype.Component;

@Component
public class AgeGroupUtil {

    public static String getGroup(AthleteEntity athlete, RaceEntity race) {
        String group = athlete.getGender().getValue();
        int age = race.getDate().getYear() - athlete.getBirthday().getYear();

        if (age >= 18 && age < 25) {
            group += "18";
        } else if (age >= 25 && age < 35) {
            group += "25";
        } else if (age >= 35 && age < 45) {
            group += "35";
        } else if (age >= 45) {
            group += "45+";
        } else {
            group += "???";
        }
        return group;
    }
}
