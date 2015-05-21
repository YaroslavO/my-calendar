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

    public boolean isTheCurrentDay() {
        return week.getDate().compareTo(date) == 0;
    }

    public boolean isCurrentMonth() {
        return week.getDate().get(Calendar.MONTH) != date.get(Calendar.MONTH);
    }

    @Override
    public String toString() {
        String result = "";

        result += isTheCurrentDay() ? MonthCalendar.COLOR_RED : "";
        result += type.isWeekendDay() ? MonthCalendar.COLOR_GREEN : "";
        result += isCurrentMonth() ? MonthCalendar.COLOR_YELLOW : "";

        result += "\t";
        result += date.get(Calendar.DAY_OF_MONTH);

        result += MonthCalendar.COLOR_BLACK;

        return result;
        /*
        if (isTheCurrentDay()) {
            return MonthCalendar.COLOR_RED + "\t" + date.get(Calendar.DAY_OF_MONTH) +
                    MonthCalendar.COLOR_BLACK;
        }
        if (isCurrentMonth()) {
            return MonthCalendar.COLOR_YELLOW + "\t" + date.get(Calendar.DAY_OF_MONTH) +
                    MonthCalendar.COLOR_BLACK;
        }
        if (type.isWeekendDay()) {
            return MonthCalendar.COLOR_GREEN + "\t" + date.get(Calendar.DAY_OF_MONTH) +
                    MonthCalendar.COLOR_BLACK;
        } else {
            return MonthCalendar.COLOR_BLACK + "\t" + date.get(Calendar.DAY_OF_MONTH);
        }
        */

    }

//    public String toHTMLTag() {
//        return
//    }
}
