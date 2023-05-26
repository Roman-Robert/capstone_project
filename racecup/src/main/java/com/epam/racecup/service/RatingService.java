package com.epam.racecup.service;

import com.epam.racecup.model.dto.ResultDTO;
import com.epam.racecup.util.RatingCalculatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RatingService {
    public final ResultService resultService;
    private final RatingCalculatorUtil ratingCalculator;

    @Autowired
    public RatingService(ResultService resultService, RatingCalculatorUtil ratingCalculator) {
        this.resultService = resultService;
        this.ratingCalculator = ratingCalculator;
    }

    public List<Map.Entry<String, Integer>> getPersonalRating() {
        List<ResultDTO> fullResultList = resultService.getAllResultsListWithPlaces();

        calculateRating(fullResultList);

        Map<String, Integer> scoreMap = new HashMap<>();

        for (ResultDTO result : fullResultList) {
            String fullName = result.getAthlete().getUser().getFirstName() + " " +
                    result.getAthlete().getUser().getLastName();
            int score = result.getRating();
            scoreMap.put(fullName, scoreMap.getOrDefault(fullName, 0) + score);
        }

        return scoreMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    public List<Map.Entry<String, Integer>> getTeamRating() {
        List<ResultDTO> fullResultList = resultService.getAllResultsListWithPlaces();

        calculateRating(fullResultList);

        Map<String, Integer> scoreMap = new HashMap<>();

        for (ResultDTO result : fullResultList) {
            String team = result.getAthlete().getTeam();
            int score = result.getRating();
            scoreMap.put(team, scoreMap.getOrDefault(team, 0) + score);
        }

        return scoreMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    public void calculateRating(List<ResultDTO> results) {
        for (ResultDTO result : results) {
            int place = (int) result.getPlace();
            result.setRating(ratingCalculator.calculateRating(place));
        }
    }
}