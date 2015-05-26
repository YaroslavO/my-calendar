package com.yaroslav.other.calendar.view.year;

import com.yaroslav.other.calendar.CustomerCalendar;
import com.yaroslav.other.calendar.FileManager;
import com.yaroslav.other.calendar.MonthCalendar;
import com.yaroslav.other.calendar.YearCalendar;
import com.yaroslav.other.calendar.view.month.HTMLAbstractMonthCalendarRenderer;
import com.yaroslav.other.calendar.view.month.MonthCalendarRenderer;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Yaroslav on 25.05.2015.
 */
public abstract class AbstractYearCalendarRendererToFile implements CalendarRenderer  {
    public final static String MAIN_DIRECTORY = "calendar";
    public static final String EXTENSION = ".html";
    public static final String NAME_FILE = "my-app.iml";

    @Override
    public void render(CustomerCalendar customerCalendar) {
        FileManager fileManager = new FileManager();
        fileManager.deleteDirectories(MAIN_DIRECTORY);
        List<YearCalendar> listYear = customerCalendar.getListYear();
        List<String> links = getListLink(listYear);

        int numberLink = 0;
        for (YearCalendar yearCalendar: listYear) {
            numberLink = saveMonthToFile(links, numberLink, yearCalendar);
        }
    }

    private int saveMonthToFile(List<String> links, int numberLink, YearCalendar yearCalendar) {
        String link = "";
        String linkNext = "";
        String linkPrevious = "";

        for (MonthCalendar monthCalendar: yearCalendar.getMonths()) {
            if (isFirstMonth(numberLink)) {
                link = links.get(numberLink);
                linkNext = links.get(numberLink + 1);
                linkPrevious = links.get(links.size() - 1);
            }

            if (isLinkInMidYear(links, numberLink)) {
                linkPrevious = links.get(numberLink - 1);
                link = links.get(numberLink);
                linkNext = links.get(numberLink + 1);
            }

            if (isLastMonth(links, numberLink)) {
                linkPrevious = links.get(numberLink - 1);
                link = links.get(numberLink);
                linkNext = links.get(0);
            }

            saveRenderToFile(link, linkNext, linkPrevious, monthCalendar);
            numberLink++;
        }

        return numberLink;
    }

    private boolean isLinkInMidYear(List<String> links, int numberLink) {
        return (numberLink < links.size() - 1) && (numberLink != 0);
    }

    private boolean isLastMonth(List<String> links, int numberLink) {
        return numberLink == links.size() - 1;
    }

    private boolean isFirstMonth(int numberLink) {
        return numberLink == 0;
    }

    private void saveRenderToFile(String link, String linkNext, String linkPrevious, MonthCalendar monthCalendar) {
        FileManager fileManager = new FileManager();
        String filePath = getPathToCreateDirectory(fileManager);
        MonthCalendarRenderer monthCalendarRenderer = new HTMLAbstractMonthCalendarRenderer();
        String result = "";
        result += getHeaderMonthToken(monthCalendar.getDate().get(Calendar.YEAR),
                getMonthName(monthCalendar.getDate().get(Calendar.MONTH)));
        result += getPreviousMonthToken(filePath + File.separator + linkPrevious);
        result += monthCalendarRenderer.render(monthCalendar);
        result += getNextMonthToken(filePath + File.separator + linkNext);
        fileManager.saveToFile(link, result);
    }

    private String getPathToCreateDirectory(FileManager fileManager) {
        String filePath = fileManager.getPathToFile(NAME_FILE).toString();
        filePath = filePath.substring(0, filePath.lastIndexOf(File.separator));
        return filePath;
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
