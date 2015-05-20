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

    public WeekDay(Calendar date, Week week) {
        this.date = date;
        this.week = week;
        type = WeekDayType.values()[date.get(Calendar.DAY_OF_WEEK) - 1];
    }

    @Override
    public String toString() {
        return !(type.isWeekendDay()) ?
                String.valueOf(date.get(Calendar.DAY_OF_MONTH)) :
                "\u001B[32m" + "\t" + String.valueOf(date.get(Calendar.DAY_OF_MONTH)) + "\u001B[30m";
    }
}
