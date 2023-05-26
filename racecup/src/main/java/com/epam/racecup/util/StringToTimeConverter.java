package com.epam.racecup.util;

import org.springframework.core.convert.converter.Converter;

import java.sql.Time;

public class StringToTimeConverter implements Converter<String, Time> {

    @Override
    public Time convert(String source) {
        if (source.isEmpty()) {
            return null;
        }
        return Time.valueOf(source);
    }
}