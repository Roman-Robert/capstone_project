package com.epam.racecup.dao;

import com.epam.racecup.models.RaceResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceResultRepository extends JpaRepository<RaceResult, Integer> {
}
