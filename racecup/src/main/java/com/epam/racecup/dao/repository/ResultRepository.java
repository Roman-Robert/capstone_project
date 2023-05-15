package com.epam.racecup.dao.repository;

import com.epam.racecup.model.RaceResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<RaceResult, Long> {
}
