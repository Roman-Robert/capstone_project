package com.epam.racecup.dao.repository;

import com.epam.racecup.model.entity.RaceResultEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<RaceResultEntity, Long> {
    Page<RaceResultEntity> findByRaceId(Long id, Pageable pageable);
    List<RaceResultEntity> findByRaceId(Long id);
}
