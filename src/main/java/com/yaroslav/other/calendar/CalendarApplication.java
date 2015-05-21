package com.yaroslav.other.calendar;

import java.util.Arrays;
import java.util.Calendar;
import java.util.stream.Collectors;

/**
 * Created by employee on 5/20/15.
 */
public class CalendarApplication {

    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        Calendar customerCalendar = inputReader.getFirstDayOfMonth(args);
        MonthCalendar monthCalendar = new MonthCalendar();
        monthCalendar.init(customerCalendar);
        String fullCommand = "";
        for (String command: args) {
            fullCommand += command;
        }
        String header = Arrays.asList(WeekDayType.values())
                .stream()
                .map(p -> p.toString())
                .collect(Collectors.joining("\t"));
        if (fullCommand.contains("--out")) {
            if (fullCommand.contains("[text]")) {
                FileManager fileManager = new FileManager();
                fileManager.saveToFile("calendar.html", monthCalendar.toString());
            }
            if (fullCommand.contains("[console]")) {
                System.out.println("\t" + header);
                System.out.println(monthCalendar.toString());
            }
        }
    }
}
