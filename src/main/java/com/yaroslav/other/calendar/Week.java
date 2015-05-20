package com.yaroslav.other.calendar;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by employee on 5/20/15.
 */
public class Week {
    private static final int COUNT_WEEK_DAYS = 7;
    private List<WeekDay> days;
    private Calendar date;

    @Override
    public String toString() {
        return days
                .stream()
                .map(p -> p.toString())
                .collect(Collectors.joining(" "));//days.stream().forEach();
    }

    public void init(Calendar date) {
        days = new ArrayList<WeekDay>();
        for (int numberDay = date.get(Calendar.DAY_OF_WEEK); numberDay <= COUNT_WEEK_DAYS; numberDay++) {
            days.add(new WeekDay(date, this));
            date = new GregorianCalendar(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH) + 1);
        }
        this.date = date;
    }

    public Week createNextWeek() {
        Week week = new Week();
        week.init(date);
        return week;
    }
}
