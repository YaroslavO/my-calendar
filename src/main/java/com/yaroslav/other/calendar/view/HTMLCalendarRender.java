package com.yaroslav.other.calendar.view;

import com.yaroslav.other.calendar.WeekDay;
import com.yaroslav.other.calendar.WeekDayType;

/**
 * Created by employee on 5/22/15.
 */
public class HTMLCalendarRender extends CalendarRender {
    public static final String HTML_OPEN_TEG_TD = "<td>";
    public static final String HTML_OPEN_CURRENT_DAY_TEG_TD = "<td style=\"color: red\">";
    public static final String HTML_OPEN_OTHER_MONTH_TEG_TD = "<td style=\"color: grey\">";
    public static final String HTML_OPEN_WEEKEND_TD = "<td style=\"color: green\">";
    public static final String HTML_OPEN_TEG_TR = "<tr>";
    public static final String HTML_OPEN_TEG_TABLE = "<table class=\"table\">";
    public static final String HTML_OPEN_TEG_TH = "<th>";
    public static final String HTML_OPEN_WEEKEND_TEG_TH = "<th style=\"color: green\">";
    public static final String HTML_CLOSE_TEG_TD = "</td>";
    public static final String HTML_CLOSE_TEG_TR = "</tr>";
    public static final String HTML_CLOSE_TEG_TABLE = "</table>";
    public static final String HTML_CLOSE_TEG_TH = "</th>";
    public static final String HTML_STYLE_BOTSTRAP_CSS = "<link rel=\"stylesheet\" " +
            "href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">";
    public static final String HTML_BOTSTRAP_JAVA_SCRIPT = "<script " +
            "src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>";

    @Override
    public String getOpenTitleToken(String title) {
        WeekDayType dayType = WeekDayType.FRIDAY;
        for (WeekDayType weekDayType : WeekDayType.values()) {
            if (weekDayType.toString().compareTo(title) == 0) {
                dayType = weekDayType;
                break;
            }
        }
        return dayType.isWeekendDay() ? HTML_OPEN_WEEKEND_TEG_TH :
                HTML_OPEN_TEG_TH;
    }

    @Override
    public String getCloseTitleToken(String title) {
        return HTML_CLOSE_TEG_TH;
    }

    @Override
    public String getOpenDayToken(WeekDay day) {
        return day.isTheCurrentDay() ?
                HTML_OPEN_CURRENT_DAY_TEG_TD :
                day.isOtherMonth() ? HTML_OPEN_OTHER_MONTH_TEG_TD :
                        day.getType().isWeekendDay() ? HTML_OPEN_WEEKEND_TD :
                                HTML_OPEN_TEG_TD;
    }

    @Override
    public String getCloseDayToken() {
        return HTML_CLOSE_TEG_TD;
    }

    @Override
    public String getOpenWeekToken() {
        return HTML_OPEN_TEG_TR;
    }

    @Override
    public String getCloseWeekToken() {
        return HTML_CLOSE_TEG_TR + ConsoleCalendarRender.END_LINE;
    }

    @Override
    public String getOpenMonthToken() {
        return HTML_STYLE_BOTSTRAP_CSS + ConsoleCalendarRender.END_LINE + HTML_OPEN_TEG_TABLE +
                ConsoleCalendarRender.END_LINE;
    }

    @Override
    public String getCloseMonthToken() {
        return HTML_CLOSE_TEG_TABLE + ConsoleCalendarRender.END_LINE + HTML_BOTSTRAP_JAVA_SCRIPT;
    }
}
