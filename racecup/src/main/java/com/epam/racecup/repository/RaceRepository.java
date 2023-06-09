package com.epam.racecup.repository;

import com.epam.racecup.model.entity.RaceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface RaceRepository extends JpaRepository<RaceEntity, Long> {
    Page<RaceEntity> findAll(Pageable pageable);
    List<RaceEntity> findAll();
    Page<RaceEntity> findByDateAfter(Date date, Pageable pageable); //add status "is_actual" check (should be =1)
    List<RaceEntity> findByDateAfter(Date date); //add status "is_actual" check (should be =1)
    List<RaceEntity> findByDateBefore(Date date); //add status "is_actual" check (should be =1)

    RaceEntity findByName(String name);
}