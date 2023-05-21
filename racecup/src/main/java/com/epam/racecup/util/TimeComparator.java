package com.epam.racecup.util;

import com.epam.racecup.model.entity.ResultEntity;

import java.util.Comparator;

public class TimeComparator implements Comparator<ResultEntity> {
    @Override
    public int compare(ResultEntity result1, ResultEntity result2) {
        if (result1.getTransitTime() == null && result2.getTransitTime() == null) {
            return 0;
        } else if (result1.getTransitTime() == null) {
            return 1;
        } else if (result2.getTransitTime() == null) {
            return -1;
        } else {
            return result1.getTransitTime().compareTo(result2.getTransitTime());
        }
    }
}
