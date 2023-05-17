package com.epam.racecup.dao.repository;

import com.epam.racecup.model.RaceResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<RaceResult, Long> {
    Page<RaceResult> findByRaceId(Long id, Pageable pageable);
    List<RaceResult> findByRaceId(Long id);
}
