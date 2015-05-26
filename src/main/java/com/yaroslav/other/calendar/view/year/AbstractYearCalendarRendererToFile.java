package com.yaroslav.other.calendar.view.year;

import com.yaroslav.other.calendar.CustomerCalendar;
import com.yaroslav.other.calendar.FileManager;
import com.yaroslav.other.calendar.MonthCalendar;
import com.yaroslav.other.calendar.YearCalendar;
import com.yaroslav.other.calendar.view.month.HTMLAbstractMonthCalendarRenderer;
import com.yaroslav.other.calendar.view.month.MonthCalendarRenderer;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Yaroslav on 25.05.2015.
 */
public abstract class AbstractYearCalendarRendererToFile implements CalendarRenderer  {
    public final static String MAIN_DIRECTORY = "calendar";
    public static final String EXTENSION = ".html";

    @Override
    public void render(CustomerCalendar customerCalendar) {
        FileManager fileManager = new FileManager();
        fileManager.deleteDirectories(MAIN_DIRECTORY);
        MonthCalendarRenderer monthCalendarRenderer = new HTMLAbstractMonthCalendarRenderer();
        List<YearCalendar> listYear = customerCalendar.getListYear();
        String filePath = fileManager.getPathToFile("my-app.iml").toString();
        filePath = filePath.substring(0, filePath.lastIndexOf(File.separator));
        List<String> links = getListLink(listYear);
        String link = "";
        String linkNext = "";
        String linkPrevious = "";
        String result;

        int numberLink = 0;

        for (YearCalendar yearCalendar: listYear) {
            for (MonthCalendar monthCalendar: yearCalendar.getMonths()) {
                if (isFirstMonth(numberLink)) {
                    link = links.get(numberLink);
                    linkNext = links.get(numberLink + 1);
                    linkPrevious = links.get(links.size() - 1);
                }

                if (numberLink < links.size() - 1) {
                    link = links.get(numberLink);
                    linkNext = links.get(numberLink + 1);
                }

                if (isLastMonth(links, numberLink)) {
                    link = links.get(numberLink);
                    linkNext = links.get(0);
                }

                result = "";
                result += getHeaderMonthToken(yearCalendar.getName(),
                        getMonthName(monthCalendar.getDate().get(Calendar.MONTH)));
                result += getPreviousMonthToken(filePath + File.separator + linkPrevious);
                result += monthCalendarRenderer.render(monthCalendar);
                result += getNextMonthToken(filePath + File.separator + linkNext);
                fileManager.saveToFile(link, result);
                linkPrevious = link;
                numberLink++;
            }

        }
    }

    private boolean isLastMonth(List<String> links, int numberLink) {
        return numberLink == links.size() - 1;
    }

    private boolean isFirstMonth(int numberLink) {
        return numberLink == 0;
    }

    private List<String> getListLink(List<YearCalendar> listYear) {
        List<String> linkList = new ArrayList<>();
        for (YearCalendar yearCalendar: listYear) {
            for (MonthCalendar monthCalendar: yearCalendar.getMonths()) {
                linkList.add(MAIN_DIRECTORY + File.separator +
                        yearCalendar.getName() + File.separator +
                        monthCalendar.getDate().get(Calendar.MONTH) + EXTENSION);
            }
        }
        return linkList;
    }

    private String getMonthName(int numberMonth) {
        switch (numberMonth) {
            case 0: return "january";
            case 1: return "february";
            case 2: return "march";
            case 3: return "april";
            case 4: return "may";
            case 5: return "june";
            case 6: return "july";
            case 7: return "august";
            case 8: return "september";
            case 9: return "october";
            case 10: return "november";
            case 11: return "december";
        }
        return "january";
    }

    public abstract String getHeaderMonthToken(Integer year, String month);
    public abstract String getPreviousMonthToken(String link);
    public abstract String getNextMonthToken(String link);

}
