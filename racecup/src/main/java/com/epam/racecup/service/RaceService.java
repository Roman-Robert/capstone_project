package com.epam.racecup.service;

import com.epam.racecup.dao.repository.RaceRepository;
import com.epam.racecup.model.entity.RaceEntity;
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

    public void saveRace(RaceEntity race) {
        raceRepository.save(race);
    }

    public Page<RaceEntity> getAllRaces(Pageable pageable) {
        return raceRepository.findAll(pageable);
    }

    public RaceEntity getRaceById(long id) {
        return raceRepository.getOne(id);
    }

    public Page<RaceEntity> findByDateAfter(Date date, Pageable pageable) {
        return raceRepository.findByDateAfter(date, pageable);
    }

    public List<RaceEntity> findByDateBefore(Date date) {
        return raceRepository.findByDateBefore(date);
    }
}
