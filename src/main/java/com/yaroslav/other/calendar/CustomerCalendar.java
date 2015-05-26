package com.yaroslav.other.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by employee on 5/25/15.
 */
public class CustomerCalendar {
    private List<YearCalendar> listYear;

    public CustomerCalendar() {
        listYear = new ArrayList<>();
    }

    public void init(List<String> taskYear) {
        for (String targetYear: taskYear) {
            YearCalendar yearCalendar = new YearCalendar();
            yearCalendar.init(targetYear);
            listYear.add(yearCalendar);
        }
    }

    public List<YearCalendar> getListYear() {
        return listYear;
    }

}
