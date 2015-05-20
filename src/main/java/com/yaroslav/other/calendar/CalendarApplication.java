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
        String Title = Arrays.asList(WeekDayType.values())
                .stream()
                .map(p -> p.toString())
                .collect(Collectors.joining());
        System.out.println(Title);
        System.out.println(monthCalendar.toString());
    }
}
