package com.yaroslav.other.calendar.view;

import com.yaroslav.other.calendar.WeekDay;
import com.yaroslav.other.calendar.WeekDayType;

/**
 * Created by employee on 5/22/15.
 */
public class ConsoleCalendarRender extends CalendarRender {

    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String TABS = "\t";
    public static final String END_LINE = "\n";

    @Override
    public String getOpenTitleToken(String title) {
        WeekDayType dayType = WeekDayType.FRIDAY;
        for (WeekDayType weekDayType : WeekDayType.values()) {
            if (weekDayType.toString().compareTo(title) == 0) {
                dayType = weekDayType;
                break;
            }
        }
        return TABS + (dayType.isWeekendDay() ? COLOR_GREEN :
                COLOR_BLACK);
    }

    @Override
    public String getCloseTitleToken(String title) {
        return COLOR_BLACK;
    }

    @Override
    public String getOpenDayToken(WeekDay day) {
        return (day.isTheCurrentDay() ?
                COLOR_RED :
                day.isOtherMonth() ? COLOR_YELLOW :
                        day.getType().isWeekendDay() ? COLOR_GREEN :
                                COLOR_BLACK) + TABS;
    }

    @Override
    public String getCloseDayToken() {
        return COLOR_BLACK;
    }

    @Override
    public String getOpenWeekToken() {
        return END_LINE;
    }

    @Override
    public String getCloseWeekToken() {
        return END_LINE;
    }

    @Override
    public String getOpenMonthToken() {
        return "";
    }

    @Override
    public String getCloseMonthToken() {
        return "";
    }
}
