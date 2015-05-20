package com.yaroslav.other.calendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by employee on 5/20/15.
 */
// TODO refactor change Date on Calendar
public class Week {
    private static final int COUNT_WEEK_DAYS = 7;
    private List<WeekDay> days;
    private Date date;

    @Override
    public String toString() {
        return "";//days.stream().forEach();
    }

    public void init(Date date) {
        days = new ArrayList<WeekDay>();
        for (int numberDay = 1; numberDay <= COUNT_WEEK_DAYS; numberDay++) {
            days.add(new WeekDay(date));
            date = new Date(date.getDate() + 1);
        }
        this.date = date;
    }

    public Week createNextWeek() {
        Week week = new Week();
        week.init(date);
        return week;
    }
}
