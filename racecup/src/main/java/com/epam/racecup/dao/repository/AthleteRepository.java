package com.epam.racecup.dao.repository;

import com.epam.racecup.model.Athlete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    Page<Athlete> findAll(Pageable pageable);
}
