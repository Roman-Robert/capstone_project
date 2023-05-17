package com.epam.racecup.service;

import com.epam.racecup.dao.repository.RaceRepository;
import com.epam.racecup.model.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
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
    public Page<Race> getAllRaces(Pageable pageable) {
        return raceRepository.findAll(pageable);
    }

    public Race getRaceById(long id) {
        return raceRepository.getOne(id);
    }

    public Page<Race> findByDateAfter(Date date, Pageable pageable) {
        return raceRepository.findByDateAfter(date, pageable);
    }

    public List<Race> findByDateBefore(Date date) {
        return raceRepository.findByDateBefore(date);
    }

    public void deleteRaceById(long id) {
        raceRepository.deleteById(id);
    }
}
