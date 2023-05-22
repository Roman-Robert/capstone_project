package com.epam.racecup.util;

import com.epam.racecup.model.dto.RaceDTO;
import com.epam.racecup.model.entity.RaceEntity;
import com.epam.racecup.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;
import java.util.Optional;

@Component
public class RaceValidator implements Validator {

    private final RaceService raceService;

    @Autowired
    public RaceValidator(RaceService raceService) {
        this.raceService = raceService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return RaceDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RaceDTO race = (RaceDTO) target;
        Date today = new Date();
        //checking for date before today

        try {
            if (race.getDate().before(today)) {
                errors.rejectValue("date", "", "Race cannot be past date");
            }
        } catch (NullPointerException e) {

        }


        //checking for equals date+name

        Optional<RaceEntity> raceEntity = raceService.getRaceByName(race.getName());

        if (raceEntity.isPresent()) {
            if (raceEntity.get().getDate().equals(race.getDate())) {
                errors.rejectValue("name", "", "This race is already on the schedule");
            }
        }
    }
}
