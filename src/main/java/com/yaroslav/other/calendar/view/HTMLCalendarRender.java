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

    public static final String HTML_TEG_TD = "td";
    public static final String HTML_TEG_TR = "tr";
    public static final String HTML_TEG_TABLE = "table";
    public static final String HTML_TEG_TH = "th";

    public void appendTag(StringBuilder sb, String tag, String contents) {
        sb.append('<').append(tag).append('>');
        sb.append(contents);
        sb.append("</").append(tag).append('>');
    }

    public void appendDataCell(StringBuilder sb, String contents) {
        appendTag(sb, HTML_TEG_TD, contents);
    }

    public void appendHeaderCell(StringBuilder sb, String contents) {
        appendTag(sb, HTML_TEG_TH, contents);
    }

    public void appendRow(StringBuilder sb, String contents) {
        appendTag(sb, HTML_TEG_TR, contents);
    }

    public String buildRow(Week week) {
        StringBuilder sb = new StringBuilder();
        String containerCell = "";

        for (WeekDay day: week.getDays()) {
            appendDataCell(sb, day.toString());
            containerCell += sb.toString();
            sb.setLength(0);
        }
        return containerCell;
    }

    @Override
    public String render(MonthCalendar monthCalendar) {
        StringBuilder sb = new StringBuilder();
        String containerTitle = "";
        String containerRow = "";

        for (String title: Arrays.asList(WeekDayType.values().toString())) {
            appendHeaderCell(sb, title);
            containerTitle += sb.toString();
            sb.setLength(0);
        }

        appendRow(sb, containerTitle);

        containerTitle = sb.toString();
        sb.setLength(0);

        for (Week week: monthCalendar.getWeeks()){
            appendRow(sb, buildRow(week));
            containerRow += sb.toString();
            sb.setLength(0);
        }

        appendTag(sb, HTML_TEG_TABLE, containerTitle + containerRow);
        return sb.toString();
    }
}
