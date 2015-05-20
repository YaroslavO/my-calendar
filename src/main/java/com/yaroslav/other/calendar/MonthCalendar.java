package com.yaroslav.other.calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by employee on 5/20/15.
 */
public class MonthCalendar {
    private List<Week> weeks;

//    private Calendar firstDateOfMonth() {
//        return new Calendar();
//    }

    public void init(Calendar date) {

    }

    @Override
    public String toString() {
        return weeks.toString();
    }
}
