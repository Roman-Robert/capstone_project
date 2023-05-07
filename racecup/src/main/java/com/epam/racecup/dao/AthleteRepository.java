package com.epam.racecup.dao;

import com.epam.racecup.models.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Integer> {
}
