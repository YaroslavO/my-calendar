package com.yaroslav.other.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by employee on 5/20/15.
 */
public class MonthCalendar {
    private final int TWO_STEP_BACK = 2;
    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_GREEN = "\u001B[32m";

    private List<Week> weeks;
    private Calendar date;


    public MonthCalendar() {
        weeks = new ArrayList<Week>();
    }

    private Calendar setFirstDayInDateOfMonth() {
        date.set(Calendar.DAY_OF_MONTH, 1);
        return date;
    }

    public void init(Calendar date) {
        this.date = date;
        setFirstDayInDateOfMonth();
        Week currentWeek;
        int countWeeks = getCountWeeks(date);
        for (int count = 1; count <= countWeeks; count++) {
            currentWeek = new Week();
            if (count == 1) {
                currentWeek.init(date);
            } else {
                currentWeek = weeks.get(count - TWO_STEP_BACK).createNextWeek();
            }
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
