package com.yaroslav.other.calendar;

import java.util.Calendar;

/**
 * Created by employee on 5/20/15.
 */
public enum WeekDayType {
    SUNDAY(Calendar.SUNDAY, "SUN", true), MONDAY(Calendar.MONDAY, "MON", false),
    TUESDAY(Calendar.TUESDAY, "TUE", false), WEDNESDAY(Calendar.WEDNESDAY, "WED", false),
    THURSDAY(Calendar.THURSDAY, "THU", false), FRIDAY(Calendar.FRIDAY, "FRI", false),
    SATURDAY(Calendar.SATURDAY, "SAT", true);

    private int id;
    private String title;
    private boolean weekendDay;

    WeekDayType(int id, String title, boolean weekendDay) {
        this.id = id;
        this.title = title;
        this.weekendDay = weekendDay;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return !(this.weekendDay) ? "\t" + title: "\u001B[32m" + "\t" + title + "\u001B[30m";
    }
}
