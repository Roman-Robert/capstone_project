package com.epam.racecup.service;

import com.epam.racecup.dao.repository.ResultRepository;
import com.epam.racecup.mapper.ResultMapper;
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
    private final ResultRepository resultRepository;
    private final ResultMapper mapper;
    private final RatingCalculatorUtil ratingCalculator;

    @Autowired
    public RatingService(ResultService resultService, ResultRepository resultRepository, ResultMapper mapper, RatingCalculatorUtil ratingCalculator) {
        this.resultService = resultService;
        this.resultRepository = resultRepository;
        this.mapper = mapper;
        this.ratingCalculator = ratingCalculator;
    }


    public List<Map.Entry<String, Integer>> getPersonalRating() {
        List<ResultDTO> fullResultList = resultService.getAllResultsListWithPlaces();
        //Calculating rating for each result
        for (ResultDTO resultDTO : fullResultList) {
            int place = (int) resultDTO.getPlace();
            resultDTO.setRating(ratingCalculator.calculateRating(place));
        }

        //mapping result
        Map<String, Integer> scoreMap = new HashMap<>();
        for (ResultDTO result:fullResultList) {
            String fullName = result.getAthlete().getUser().getFirstName()+" "+
                    result.getAthlete().getUser().getLastName();
            int score = result.getRating();
            scoreMap.put(fullName, scoreMap.getOrDefault(fullName,0)+score);
        }

        List<Map.Entry<String, Integer>> sortedResults = scoreMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        return sortedResults;
//        return fullResultList;


    }

    public List<ResultDTO> getTeamRating() {
        return null;
    }
}
