package com.epam.racecup.dao.repository;

import com.epam.racecup.model.Race;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface RaceRepository extends JpaRepository<Race, Long> {
    Page<Race> findAll(Pageable pageable);
    Page<Race> findByDateAfter(Date date, Pageable pageable); //add status "is_actual" check (should be =1)
    List<Race> findByDateBefore(Date date); //add status "is_actual" check (should be =1)

}
