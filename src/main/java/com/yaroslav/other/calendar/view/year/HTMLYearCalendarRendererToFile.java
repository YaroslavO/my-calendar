package com.yaroslav.other.calendar.view.year;

/**
 * Created by Yaroslav on 25.05.2015.
 */
public class HTMLYearCalendarRendererToFile extends YearCalendarRendererToFile{
    public static final String START_BUTTON = "<a href=\"";
    public static final String END_NEXT_BUTTON = "\" class=\"btn btn-block btn-success\">Next month</a>";
    public static final String END_PREVIOUS_BUTTON = "\" class=\"btn btn-block btn-success\">Previous month</a>";
    public static final String END_LINE = "\n";

    @Override
    public String getPreviousMonthToken(String link) {
        String result = "";
        result += START_BUTTON;
        result += link;
        result += END_PREVIOUS_BUTTON;
        result += END_LINE;
        return result;
    }

    @Override
    public String getNextMonthToken(String link) {
        String result = "";
        result += START_BUTTON;
        result += link;
        result += END_NEXT_BUTTON;
        result += END_LINE;
        return result;
    }
}
