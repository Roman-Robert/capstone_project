package com.epam.racecup.service;

import com.epam.racecup.dao.repository.AthleteRepository;
import com.epam.racecup.dao.repository.RaceRepository;
import com.epam.racecup.dao.repository.ResultRepository;
import com.epam.racecup.model.Athlete;
import com.epam.racecup.model.RaceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private final ResultRepository resultRepository;
    private final AthleteRepository athleteRepository;
    private final RaceRepository raceRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository, AthleteService athleteService, RaceService raceService, AthleteRepository athleteRepository, RaceRepository raceRepository) {
        this.resultRepository = resultRepository;
        this.athleteRepository = athleteRepository;
        this.raceRepository = raceRepository;
    }

    public List<RaceResult> getRaceResultsByRaceId(Long race_id) {
        return resultRepository.findByRaceId(race_id);
    }

    public String getAthleteFullNameById(long id) {
        Athlete athlete = athleteRepository.getOne(id);
        return athlete.getUser().getFirstName() + " " + athlete.getUser().getLastName();
    }

}

