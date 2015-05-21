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

    public Week() {

    }

    public Week(Calendar date) {
        this.currentDate = new GregorianCalendar(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
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

    private Calendar setFirstDayInDateOfMonth() {
        date.set(Calendar.DAY_OF_MONTH, 1);
        return date;
    }

    public void init(Calendar date) {
        days = new ArrayList<WeekDay>();
        this.date = new GregorianCalendar(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
        setFirstDayInDateOfMonth();
        if (date.get(Calendar.DAY_OF_WEEK) > 1) {
            int numberDayOfWeek = date.get(Calendar.DAY_OF_WEEK) + 1;
            date.set(Calendar.MONTH, date.get(Calendar.MONTH) - 1);
            int countDayOFWeekMonthBefore = date.getActualMaximum(Calendar.DAY_OF_MONTH);
            date.set(Calendar.DAY_OF_MONTH, countDayOFWeekMonthBefore - numberDayOfWeek);

            for (int numberDay = 1; numberDay <= numberDayOfWeek + 1;
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

        this.date = date;
    }

    public Week createNextWeek() {
        Week week = new Week(currentDate);
        week.init(date);
        return week;
    }
}
