package com.yaroslav.other.calendar;

import com.yaroslav.other.calendar.view.ConsoleCalendarRender;
import com.yaroslav.other.calendar.view.HTMLCalendarRender;
import com.yaroslav.other.calendar.view.Render;

import java.util.Arrays;
import java.util.Calendar;
import java.util.stream.Collectors;

/**
 * Created by employee on 5/20/15.
 */
public class CalendarApplication {
    private static final String COMMAND_OUT = "--out";
    private static final String COMMAND_TEXT = "[text]";
    private static final String COMMAND_CONSOLE = "[console]";
    private static final String FILE_NAME = "calendar.html";

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
                Render render = new HTMLCalendarRender();
                fileManager.saveToFile(FILE_NAME, render.render(monthCalendar));
            }
            if (fullCommand.contains(COMMAND_CONSOLE)) {
                Render render = new ConsoleCalendarRender();
                System.out.println(render.render(monthCalendar));
            }
        }
    }
}
