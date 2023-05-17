package com.epam.racecup.dao.repository;

import com.epam.racecup.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface RaceRepository extends JpaRepository<Race, Long> {
    List<Race> findByDateAfter(Date date); //add status "is_actual" check (should be =1)
    List<Race> findByDateBefore(Date date); //add status "is_actual" check (should be =1)

}
