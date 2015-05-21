package com.yaroslav.other.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by employee on 5/20/15.
 */
public class MonthCalendar {
    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String HTML_TABLE = "<>";
    private List<Week> weeks;
    private Calendar date;

    public MonthCalendar() {
        weeks = new ArrayList<Week>();
    }

    public void init(Calendar date) {
        this.date = date;
        Week currentWeek;
        int countWeeks = getCountWeeks(date) - 1;
        currentWeek = new Week(date);
        currentWeek.init();
        weeks.add(currentWeek);
        for (int count = 0; count < countWeeks; count++) {
            currentWeek = weeks.get(count).createNextWeek();
            weeks.add(currentWeek);
        }
    }

    @Override
    public String toString() {
        return weeks
                .stream()
                .map(p -> p.toString())
                .collect(Collectors.joining("\n\n"));
    }

    public int getCountWeeks(Calendar calendar) {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int cntDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int countWeek = (dayOfWeek + cntDayOfMonth) / Calendar.SATURDAY;

        if (((dayOfWeek + cntDayOfMonth) % Calendar.SATURDAY) != 0) {
            countWeek += 1;
        }

        return countWeek;
    }
}
