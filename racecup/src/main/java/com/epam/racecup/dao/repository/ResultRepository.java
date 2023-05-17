package com.epam.racecup.dao.repository;

import com.epam.racecup.model.RaceResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<RaceResult, Long> {
    List<RaceResult> findByRaceId(Long id);

    /*//results table for each race by race id
    @Query("SELECT * FROM race_result JOIN user WHERE athlete_id = id AND race_id=:id ORDER BY transit_time ASC")
    List<?????> getRaceResultByRaceId(@Param("id") Long id);*/


    /*//results table for "my races" link in the personal account
    @Query("SELECT * FROM race JOIN race_result WHERE id=race_id AND athlete_id=:id ORDER BY date DESC")
    List<?????> getRaceResultByAthleteId(@Param("id") Long id);*/

}
