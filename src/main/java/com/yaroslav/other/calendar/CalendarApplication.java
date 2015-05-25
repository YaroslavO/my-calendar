package com.yaroslav.other.calendar;

import com.yaroslav.other.calendar.file.SourceLoader;
import com.yaroslav.other.calendar.view.ConsoleAbstractCalendarMonthCalendarRenderer;
import com.yaroslav.other.calendar.view.HTMLAbstractCalendarMonthCalendarRenderer;
import com.yaroslav.other.calendar.view.MonthCalendarRenderer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.stream.Collectors;

/**
 * Created by employee on 5/20/15.
 */
public class CalendarApplication {
    private static final String COMMAND_OUT = "--out";
    private static final String COMMAND_TEXT = "[text]";
    private static final String COMMAND_CONSOLE = "[console]";
    private static final String FILE_NAME = "calendar.txt";

    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        Calendar customerCalendar = inputReader.getFirstDayOfMonth(args);
        MonthCalendar monthCalendar = new MonthCalendar();
        monthCalendar.init(customerCalendar);
        String fullCommand = "";

        for (String command: args) {
            fullCommand += command;
        }

        if (fullCommand.contains(COMMAND_OUT)) {
            if (fullCommand.contains(COMMAND_TEXT)) {
                FileManager fileManager = new FileManager();
                MonthCalendarRenderer monthCalendarRenderer = new HTMLAbstractCalendarMonthCalendarRenderer();
                fileManager.saveToFile(FILE_NAME, monthCalendarRenderer.render(monthCalendar));
            }
            if (fullCommand.contains(COMMAND_CONSOLE)) {
                MonthCalendarRenderer monthCalendarRenderer = new ConsoleAbstractCalendarMonthCalendarRenderer();
                System.out.println(monthCalendarRenderer.render(monthCalendar));
            }
        }

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

    }
}
