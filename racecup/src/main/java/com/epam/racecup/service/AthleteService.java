package com.epam.racecup.service;

import com.epam.racecup.dao.repository.AthleteRepository;
import com.epam.racecup.model.entity.AthleteEntity;
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

    public void saveAthlete(AthleteEntity athlete) {
        athleteRepository.save(athlete);
    }

    public Page<AthleteEntity> getAllAthletes(Pageable pageable) {
        return athleteRepository.findAll(pageable);
    }

}
