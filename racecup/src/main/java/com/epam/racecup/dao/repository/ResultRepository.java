package com.epam.racecup.dao.repository;

import com.epam.racecup.model.RaceResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<RaceResult, Long> {
    List<RaceResult> findByRaceId(Long id);

//    @Query("SELECT * FROM race_result JOIN user WHERE athlete_id = id AND race_id=:id ORDER BY transit_time ASC")
//    List<List<String>> getResultWithAthleteNameByRaceId(@Param("id") Long id);
}
