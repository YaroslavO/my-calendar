package com.yaroslav.other.calendar.view.year;

import com.yaroslav.other.calendar.CustomerCalendar;
import com.yaroslav.other.calendar.FileManager;
import com.yaroslav.other.calendar.MonthCalendar;
import com.yaroslav.other.calendar.YearCalendar;
import com.yaroslav.other.calendar.view.month.HTMLMonthCalendarRenderer;
import com.yaroslav.other.calendar.view.month.MonthCalendarRenderer;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Yaroslav on 25.05.2015.
 */
public abstract class YearCalendarRendererToFile implements CalendarRenderer  {
    public final static String SLASH = "\\";
    public final static String MAIN_DIRECTORY = "calendar";
    public static final String EXTENSION = ".html";

    @Override
    public void renderer(CustomerCalendar customerCalendar) {
        FileManager fileManager = new FileManager();
        MonthCalendarRenderer monthCalendarRenderer = new HTMLMonthCalendarRenderer();
        List<YearCalendar> listYear = customerCalendar.getListYear();

        String link = "";
        String linkNext = "";
        String linkPrevious = "";
        String result;

        for (YearCalendar yearCalendar: listYear) {
            for (MonthCalendar monthCalendar: yearCalendar.getMonths()) {
                link = "";
                result = "";
                link += "../" + MAIN_DIRECTORY + SLASH +
                        yearCalendar.getName() + SLASH +
                        monthCalendar.getDate().get(Calendar.MONTH) + EXTENSION;
                result += getPreviousMonthToken(linkPrevious);
                result += monthCalendarRenderer.render(monthCalendar);
                result += getNextMonthToken(linkNext);
                fileManager.saveToFile(link, result);
                linkPrevious = link;
            }

        }
    }

    public abstract String getPreviousMonthToken(String link);
    public abstract String getNextMonthToken(String link);

}
