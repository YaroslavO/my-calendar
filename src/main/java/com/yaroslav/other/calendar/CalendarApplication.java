package com.yaroslav.other.calendar;

import com.yaroslav.other.calendar.view.year.CalendarRenderer;
import com.yaroslav.other.calendar.view.year.HTMLAbstractYearCalendarRendererToFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 5/20/15.
 */
public class CalendarApplication {
    private static final String FILE_NAME = "calendar.txt";

    public static void main(String[] args) {

        FileManager fileManager = new FileManager();
        List<String> listYearAndMonth = new ArrayList<String>();
        listYearAndMonth.add("2015 jun jul");

        try {
            listYearAndMonth.clear();
            listYearAndMonth = fileManager.loadSource(FILE_NAME);
        }  catch (FileNotFoundException e) {
            System.out.println("file not found: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        CustomerCalendar calendar = new CustomerCalendar();
        calendar.init(listYearAndMonth);

        CalendarRenderer calendarRenderer = new HTMLAbstractYearCalendarRendererToFile();
        calendarRenderer.renderer(calendar);
    }
}
