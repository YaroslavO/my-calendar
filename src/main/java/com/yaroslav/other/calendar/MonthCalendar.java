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
        Week currentWeek;
        for (int count = 1; count <= getCountWeeks(date); count++) {
            currentWeek = new Week();
            if (count == 1) {
                currentWeek.init(date);
            } else {
                currentWeek = weeks.get(count - 1).createNextWeek();
            }
            weeks.add(currentWeek);
        }
    }

    @Override
    public String toString() {
        return weeks.toString();
    }

    public int getCountWeeks(Calendar calendar) {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int cntDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int countWeek = (dayOfWeek + cntDayOfMonth) / 7;

        if (((dayOfWeek + cntDayOfMonth) % 7) != 0) {
            countWeek += 1;
        }

        return countWeek;
    }
}
