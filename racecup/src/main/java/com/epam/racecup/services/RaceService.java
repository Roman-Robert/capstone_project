package com.epam.racecup.services;

import com.epam.racecup.dao.RaceRepository;
import com.epam.racecup.models.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {

    private final RaceRepository raceRepository;

    @Autowired
    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public void saveRace(Race race) {
        raceRepository.save(race);
    }
    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    public Race getRaceById(int id) {
        return raceRepository.getOne(id);
    }

    public void updateRace(Race race) {
        //implement this method
    }
    public void deleteRaceById(int id) {
        raceRepository.deleteById(id);
    }


}
