package com.epam.racecup.repository;

import com.epam.racecup.model.entity.AthleteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<AthleteEntity, Long> {
    Page<AthleteEntity> findAll(Pageable pageable);
}