package com.yaroslav.other.calendar.view;

import com.yaroslav.other.calendar.MonthCalendar;
import com.yaroslav.other.calendar.Week;
import com.yaroslav.other.calendar.WeekDay;
import com.yaroslav.other.calendar.WeekDayType;

import java.util.Arrays;

/**
 * Created by employee on 5/22/15.
 */
public class HTMLCalendarRender extends CalendarRender{
    public static final String HTML_OPEN_TEG_TD = "<td>";
    public static final String HTML_OPEN_TEG_TR = "<tr>";
    public static final String HTML_OPEN_TEG_TABLE = "<table>";
    public static final String HTML_OPEN_TEG_TH = "<th>";
    public static final String HTML_CLOSE_TEG_TD = "</td>";
    public static final String HTML_CLOSE_TEG_TR = "</tr>";
    public static final String HTML_CLOSE_TEG_TABLE = "</table>";
    public static final String HTML_CLOSE_TEG_TH = "</th>";

    @Override
    public String getOpenTitleToken(String title) {
        return null;
    }

    @Override
    public String getCloseTitleToken(String title) {
        return null;
    }

    @Override
    public String getOpenDayToken(WeekDay day) {
        return null;
    }

    @Override
    public String getCloseDayToken(WeekDay day) {
        return null;
    }

    @Override
    public String getOpenWeekToken() {
        return null;
    }

    @Override
    public String getCloseWeekToken() {
        return null;
    }

    @Override
    public String getOpenMonthToken() {
        return null;
    }

    @Override
    public String getCloseMonthToken() {
        return null;
    }
}
