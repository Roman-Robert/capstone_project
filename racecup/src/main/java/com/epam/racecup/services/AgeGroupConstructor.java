package com.epam.racecup.services;

import com.epam.racecup.models.Athlete;
import org.apache.log4j.Logger;

import java.sql.Date;

public class AgeGroupConstructor {
    Logger logger = Logger.getLogger(AgeGroupConstructor.class);

    public String getAge(Athlete athlete, Date raceDate) {

        String gender = athlete.getGender().toString();
        int age = athlete.getBirthday().getYear() - raceDate.getYear();

        if (age >=18 && age<25) {
            return gender + "18";
        } else if (age >=25 && age < 35) {
            return gender + "25";
        } else if (age >=35 && age < 45) {
            return gender + "35";
        } else if (age >= 45) {
            return gender + "45+";
        } else {
            logger.error("Athlete " + athlete.getId() + "is too young for races.");
        }
        return "?";
    }
}
