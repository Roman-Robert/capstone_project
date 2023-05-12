package com.epam.racecup.service;

import com.epam.racecup.model.Athlete;
import org.apache.log4j.Logger;

import java.sql.Date;

public class AgeGroupConstructor {
    Logger logger = Logger.getLogger(AgeGroupConstructor.class);

    public String getAge(Athlete athlete, Date raceDate) {
        String group=athlete.getGender().toString();
        int age = athlete.getBirthday().getYear() - raceDate.getYear();

        if (age >=18 && age<25) {
            group += "18";
        } else if (age >=25 && age < 35) {
            group +="25";
        } else if (age >=35 && age < 45) {
            group +="35";
        } else if (age >= 45) {
            group +="45+";
        } else {
            logger.error("Athlete " + athlete.getId() + "is too young for races.");
        }
        return group;
    }
}
