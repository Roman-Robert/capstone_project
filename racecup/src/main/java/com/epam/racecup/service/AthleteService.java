package com.epam.racecup.service;

import com.epam.racecup.dao.repository.AthleteRepository;
import com.epam.racecup.model.Athlete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;

    @Autowired
    public AthleteService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public void saveAthlete(Athlete athlete) {
        athleteRepository.save(athlete);
    }

    public Page<Athlete> getAllAthletes(Pageable pageable) {
        return athleteRepository.findAll(pageable);
    }

    public Athlete getAthleteByUserId(long id) {
        return athleteRepository.getOne(id);
    }

    //Change user status only 1->0
    public void deleteAthleteByUserId(long id) {
        athleteRepository.deleteById(id);
    }


}
