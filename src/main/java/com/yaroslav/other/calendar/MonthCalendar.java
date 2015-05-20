package com.yaroslav.other.calendar;

import java.util.Date;
import java.util.List;

/**
 * Created by employee on 5/20/15.
 */
public class MonthCalendar {
    private List<Week> weeks;

    private Date firstDateOfMonth() {
        return new Date();
    }

    public void init(Date date) {

    }

    @Override
    public String toString() {
        return weeks.toString();
    }
}
