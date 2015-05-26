package com.yaroslav.other.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by employee on 5/25/15.
 */
public class CustomerCalendar {
    private String task;
    private List<YearCalendar> listYear;

    public CustomerCalendar(String task) {
        this.task = task;
        listYear = new ArrayList<>();
    }

    public void init() {
        for (String targetYear: task.split("\n")) {
            YearCalendar yearCalendar = new YearCalendar();
            yearCalendar.init(targetYear);
            listYear.add(yearCalendar);
        }
    }

    public List<YearCalendar> getListYear() {
        return listYear;
    }

}
