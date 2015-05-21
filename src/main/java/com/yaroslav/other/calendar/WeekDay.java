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
        if (week.getDate().compareTo(date) == 0) {
            return MonthCalendar.COLOR_RED + "\t" + date.get(Calendar.DAY_OF_MONTH) +
                    MonthCalendar.COLOR_BLACK;
        }
        if (week.getDate().get(Calendar.MONTH) != date.get(Calendar.MONTH)) {
            return MonthCalendar.COLOR_YELLOW + "\t" + date.get(Calendar.DAY_OF_MONTH) +
                    MonthCalendar.COLOR_BLACK;
        }
        if (type.isWeekendDay()) {
            return MonthCalendar.COLOR_GREEN + "\t" + date.get(Calendar.DAY_OF_MONTH) +
                    MonthCalendar.COLOR_BLACK;
        } else {
            return MonthCalendar.COLOR_BLACK + "\t" + date.get(Calendar.DAY_OF_MONTH);
        }
    }
}
