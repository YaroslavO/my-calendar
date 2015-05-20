package com.yaroslav.other.calendar;

import java.util.Calendar;

/**
 * Created by employee on 5/20/15.
 */
public class CalendarApplication {

    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        Calendar customerCalendar = inputReader.getFirstDayOfMonth(args);
        MonthCalendar monthCalendar = new MonthCalendar();
        monthCalendar.init(customerCalendar);
        System.out.println(customerCalendar.toString());
    }
}
