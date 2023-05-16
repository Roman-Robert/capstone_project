package com.epam.racecup.dao.repository;

import com.epam.racecup.model.RaceResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<RaceResult, Long> {
    List<RaceResult> findByRaceId(Long race_id);
}
