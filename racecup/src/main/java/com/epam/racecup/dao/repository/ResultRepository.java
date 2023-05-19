package com.epam.racecup.dao.repository;

import com.epam.racecup.model.entity.ResultEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<ResultEntity, Long> {
    Page<ResultEntity> findByRaceId(Long id, Pageable pageable);
    List<ResultEntity> findByRaceId(Long id);
    List<ResultEntity> findByAthleteId(Long id);
}
