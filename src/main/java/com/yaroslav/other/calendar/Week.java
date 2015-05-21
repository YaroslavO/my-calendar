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
    private Calendar currentDate;

    public Week(Calendar date) {
        this.currentDate = new GregorianCalendar(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
        this.date = new GregorianCalendar(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
        this.date = setFirstDayInDateOfMonth(this.date);
    }

    public Week(Calendar currentDate, Calendar nextDate) {
        this.currentDate = currentDate;
        date = nextDate;
    }

    public Calendar getDate() {
        return currentDate;
    }

    @Override
    public String toString() {
        return days
                .stream()
                .map(p -> p.toString())
                .collect(Collectors.joining(" "));
    }

    private Calendar setFirstDayInDateOfMonth(Calendar date) {
        date.set(Calendar.DAY_OF_MONTH, 1);
        return date;
    }

    public void init() {
        days = new ArrayList<WeekDay>();
        if (date.get(Calendar.DAY_OF_WEEK) > 1) {
            int numberDayOfWeek = date.get(Calendar.DAY_OF_WEEK);
            date.set(Calendar.MONTH, date.get(Calendar.MONTH) - 1);
            int countDayOFWeekMonthBefore = date.getActualMaximum(Calendar.DAY_OF_MONTH);
            date.set(Calendar.DAY_OF_MONTH, countDayOFWeekMonthBefore - numberDayOfWeek);

            for (int numberDay = 1; numberDay < numberDayOfWeek;
                 numberDay++) {
                days.add(new WeekDay(date, this));
                date = new GregorianCalendar(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH) + 1);
            }

            date.set(Calendar.DAY_OF_MONTH, 1);
            date.set(Calendar.MONTH, date.get(Calendar.MONTH) + 1);
        }

        for (int numberDay = date.get(Calendar.DAY_OF_WEEK); numberDay <= COUNT_WEEK_DAYS; numberDay++) {
            days.add(new WeekDay(date, this));
            date = new GregorianCalendar(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH) + 1);
        }
    }

    public Week createNextWeek() {
        Week week = new Week(currentDate, date);
        week.init();
        return week;
    }
}
