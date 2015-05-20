package com.yaroslav.other.calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by employee on 5/20/15.
 */
public class MonthCalendar {
    private List<Week> weeks;
    private Calendar date;

    private Calendar firstDateOfMonth() {
        date.set(Calendar.DAY_OF_MONTH, 1);
        return date;
    }

    public void init(Calendar date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return weeks.toString();
    }
}
