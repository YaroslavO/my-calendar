package com.yaroslav.other.calendar;

import java.util.Calendar;

/**
 * Created by employee on 5/20/15.
 */
public class WeekDay {
    private WeekDayType type;
    private Calendar day;
    private Week week;

    public WeekDay(Calendar date, Week week) {
        this.day = date;
        this.week = week;
        type = WeekDayType.values()[date.get(Calendar.DAY_OF_WEEK) - 1];
    }

    @Override
    public String toString() {
        String result = "";
        result += isTheCurrentDate() ? MonthCalendar.COLOR_RED: "";
        result += type.isWeekendDay() ? MonthCalendar.COLOR_GREEN: "";
        result += isOtherMonth() ? MonthCalendar.COLOR_YELLOW: "";
        result += "\t" + day.get(Calendar.DAY_OF_MONTH);
        result += MonthCalendar.COLOR_BLACK;
        return result;
    }

    public boolean isTheCurrentDate() {
        return week.getDate().compareTo(day) == 0;
    }

    public boolean isOtherMonth() {
        return week.getDate().get(Calendar.MONTH) != day.get(Calendar.MONTH);
    }
}
