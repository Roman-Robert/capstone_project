package com.epam.racecup.util;

import org.springframework.stereotype.Component;

@Component
public class StringFormatter {

    public static String format(String str) {
        String[] words = str.split("\\s+");

        StringBuilder formattedName = new StringBuilder();
        for (String word : words) {
            String formattedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            formattedName.append(formattedWord).append(" ");
        }

        return formattedName.toString().trim();
    }
}