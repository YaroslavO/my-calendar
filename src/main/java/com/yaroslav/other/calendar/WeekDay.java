package com.yaroslav.other.calendar;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by employee on 5/20/15.
 */
public class WeekDay {
    private WeekDayType type;
    private Calendar date;
    private Week week;

    public WeekDay(Calendar date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return date.toString();
    }
}
