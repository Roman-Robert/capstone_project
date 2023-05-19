package com.epam.racecup.util;

import org.springframework.stereotype.Component;

@Component
public class RatingCalculatorUtil {

    public int calculateRating(int place) {
        int rating;

        if (place == 1) {
            rating = 100;
        } else if (place == 2) {
            rating = 90;
        } else if (place == 3) {
            rating = 75;
        } else {
            rating = 60 - place * 2;
        }
        return rating;
    }

}
