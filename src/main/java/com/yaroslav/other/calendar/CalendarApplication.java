package com.yaroslav.other.calendar;

import com.yaroslav.other.calendar.file.SourceLoader;
import com.yaroslav.other.calendar.view.year.CalendarRenderer;
import com.yaroslav.other.calendar.view.year.HTMLAbstractYearCalendarRendererToFile;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by employee on 5/20/15.
 */
public class CalendarApplication {
    private static final String FILE_NAME = "calendar.txt";

    public static void main(String[] args) {

        SourceLoader sourceLoader = new SourceLoader();
        String source = "2015 jul";

        try {
            source = sourceLoader.loadSource(FILE_NAME);
        }  catch (FileNotFoundException e) {
            System.out.println("file not found: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        CustomerCalendar calendar = new CustomerCalendar(source);
        calendar.init();

        CalendarRenderer calendarRenderer = new HTMLAbstractYearCalendarRendererToFile();
        calendarRenderer.renderer(calendar);
    }
}
