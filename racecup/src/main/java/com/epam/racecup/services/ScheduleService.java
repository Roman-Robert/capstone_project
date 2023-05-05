package com.epam.racecup.services;

import com.epam.racecup.dao.RaceRepository;
import com.epam.racecup.models.Race;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final RaceRepository raceRepository;

    public ScheduleService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    public Race getRaceById(int id) {
        return raceRepository.getOne(id);
    }
}
