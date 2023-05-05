package com.epam.racecup.dao;

import com.epam.racecup.models.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, Integer> {
}
