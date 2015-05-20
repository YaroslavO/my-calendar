package com.yaroslav.other.calendar;

import java.util.Date;

/**
 * Created by employee on 5/20/15.
 */
public class WeekDay {
    private WeekDayType type;
    private Date date;
    private Week week;

    public WeekDay(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return date.toString();
    }
}
