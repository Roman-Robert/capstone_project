package com.epam.racecup.service;

import com.epam.racecup.dao.repository.ResultRepository;
import com.epam.racecup.model.RaceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<RaceResult> getRaceResultsByRaceId(Long race_id) {
        return resultRepository.findByRaceId(race_id);
    }

    public void saveResult(RaceResult raceResult) {
        resultRepository.save(raceResult);
    }
}
