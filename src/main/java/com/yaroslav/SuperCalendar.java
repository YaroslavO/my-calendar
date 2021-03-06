package com.yaroslav;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yaroslav on 18.05.2015.
 */
public class SuperCalendar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int currentMonth;
        int currentYear;
        int currentDay;
        Calendar calendar;
        int dayOfWeek;
        int countDayOfMonth;
        int countDayOfMonthBefore;
        String yearMonthDay;

        do {
            if ((args != null) && ((args.length == 3) || (args.length == 1))) {
                if ((args.length == 1) && (args[0].contains("/"))) {
                    yearMonthDay = args[0];
                    args = null;
                } else {
                    if (args.length == 3) {
                        yearMonthDay = args[0] + " " + args[1] + " " + args[2];
                        args = null;
                    } else {
                        continue;
                    }
                }
            } else {
                System.out.println("Please enter year month day");
                yearMonthDay = in.nextLine();
            }

            if (!checkString(yearMonthDay)) {
                System.out.println("You enter wrong date Please enter date such as \"yyyy mm dd\" or \"yyyy/mm/dd\"");
                continue;
            }

            ArrayList<Integer> yMDList = getYearMonthDayList(yearMonthDay);

            if (yMDList == null) {
                System.out.println("Oooops.. :(");
                continue;
            }

            if (yMDList.size() != 3) {
                System.out.println("You must enter 3 parameter year month and day\n");
                continue;
            }

            currentYear = yMDList.get(0);
            currentMonth = yMDList.get(1);
            currentDay = yMDList.get(2);

            calendar = new GregorianCalendar(currentYear, currentMonth, currentDay);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            countDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

            countDayOfMonthBefore = getCountDeys(calendar);
            int countWeek = getCountWeeks(calendar);

            displayCalendar(currentDay, dayOfWeek, countDayOfMonth, countDayOfMonthBefore, countWeek);

        } while (checkCommand());

    }

    private static void displayCalendar(int currentDay, int dayOfWeek,
                                        int countDayOfMonth, int countDayOfMonthBefore, int countWeek) {
        int numberDayOfWeek;
        int numberDay = 0;

        System.out.println("\u001B[32m\tSun\u001B[34m\tMon\tTue\tWed\tThu\tFri\u001B[32m\tSat\u001B[30m");

        for (int numberWeek = 1; numberWeek <= countWeek; numberWeek++) {
            numberDayOfWeek = 1;

            while (numberDayOfWeek <= 7) {
                numberDay += 1;

                if (numberDay <= dayOfWeek) {
                    displayDayOfMonthBefore(dayOfWeek, countDayOfMonthBefore, numberDay);
                } else {
                    if ((numberDay - dayOfWeek) <= countDayOfMonth) {
                        if ((numberDay - dayOfWeek) == currentDay) {
                            displayDayThisMonthIsWeekend(dayOfWeek, numberDay);
                        } else {
                            if (checkDayOfWeekend(numberDay, numberWeek)) {
                                System.out.print("\u001B[32m" + "\t" +
                                        String.valueOf(numberDay - dayOfWeek) +
                                        "\u001B[30m");
                                numberDayOfWeek++;
                                continue;
                            }

                            displayDayOfThisMonth(dayOfWeek, numberDay);
                        }
                    } else {
                        displayDayOfMonthAfter(dayOfWeek, countDayOfMonth, numberDay);
                    }
                }

                numberDayOfWeek++;
            }
            System.out.print("\n");
        }
    }

    private static void displayDayThisMonthIsWeekend(int dayOfWeek, int numberDay) {
        System.out.print("\u001B[31m\t" + String.valueOf(numberDay - dayOfWeek) + "\u001B[30m");
    }

    private static void displayDayOfThisMonth(int dayOfWeek, int numberDay) {
        System.out.print("\t" + String.valueOf(numberDay - dayOfWeek));
    }

    private static void displayDayOfMonthAfter(int dayOfWeek, int countDayOfMonth, int numberDay) {
        System.out.print("\u001B[33m" + "\t" +
                String.valueOf(numberDay - countDayOfMonth - dayOfWeek) +
                "\u001B[30m");
    }

    private static boolean checkDayOfWeekend(int numberDay, int numberWeek) {
        return ((numberDay % 6) == 0 && (numberWeek == 6)) || ((numberDay % 6) == numberWeek) ||
                ((numberDay % 7) == 0);
    }

    private static void displayDayOfMonthBefore(int dayOfWeek, int countDayOfMonthBefore, int numberDay) {
        System.out.print("\u001B[33m" + "\t" +
                String.valueOf(countDayOfMonthBefore - dayOfWeek + numberDay) +
                "\u001B[30m");
    }

    private static boolean checkCommand() {
        Scanner in = new Scanner(System.in);
        String command;
        System.out.println("Enter stop for exit");
        command = in.nextLine();

        return !command.contains("stop");
    }

    /**
     * get year month day from string
     *
     * @param val string contain year month day or empty string
     * @return list
     */
    public static ArrayList<Integer> getYearMonthDayList(String val) {
        ArrayList<Integer> paramList = new ArrayList<Integer>();

        if (val.length() == 0) {
            paramList.add(2015);
            paramList.add(5);
            paramList.add(19);
            return paramList;
        }

        val = val.toLowerCase();

        int count = 1;

        if (val.contains(" ")) {
            for (String item : val.split(" ")) {
                if (count == 1) {
                    paramList.add(Integer.valueOf(item));
                }

                if (count == 2) {
                    paramList.add(getMonth(item));
                }

                if (count == 3) {
                    paramList.add(Integer.valueOf(item));
                }

                count++;
            }

            return paramList;
        }

        if (val.contains("/")) {
            for (String item : val.split("/")) {
                if (count == 1) {
                    paramList.add(Integer.valueOf(item));
                }

                if (count == 2) {
                    paramList.add(getMonth(item));
                }

                if (count == 3) {
                    paramList.add(Integer.valueOf(item));
                }

                count++;
            }

            return paramList;
        }

        return paramList;
    }

    /**
     * get count week in current month
     *
     * @param calendar - object
     * @return count week in current month
     */
    public static int getCountWeeks(Calendar calendar) {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int cntDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int countWeek = (dayOfWeek + cntDayOfMonth) / 7;

        if (((dayOfWeek + cntDayOfMonth) % 7) != 0) {
            countWeek += 1;
        }

        return countWeek;
    }

    /**
     * Get count day in before current month
     *
     * @param calendar - object
     * @return - count day in month before this month
     */
    public static int getCountDeys(Calendar calendar) {
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        if ((month - 1) < 0) {
            month = 11;
            year -= 1;
        }

        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);

        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static int getMonth(String value) {
        if ((value.compareTo("1") == 0) || (value.compareTo("01") == 0) ||
                (value.compareTo("jan") == 0) || (value.compareTo("january") == 0)) {
            return 0;
        }

        if ((value.compareTo("2") == 0) || (value.compareTo("02") == 0) ||
                (value.compareTo("feb") == 0) || (value.compareTo("february") == 0)) {
            return 1;
        }

        if ((value.compareTo("3") == 0) || (value.compareTo("03") == 0) ||
                (value.compareTo("mar") == 0) || (value.compareTo("march") == 0)) {
            return 2;
        }

        if ((value.compareTo("4") == 0) || (value.compareTo("04") == 0) ||
                (value.compareTo("apr") == 0) || (value.compareTo("april") == 0)) {
            return 3;
        }

        if ((value.compareTo("5") == 0) || (value.compareTo("05") == 0) ||
                (value.compareTo("may") == 0)) {
            return 4;
        }

        if ((value.compareTo("6") == 0) || (value.compareTo("06") == 0) ||
                (value.compareTo("jun") == 0) || (value.compareTo("june") == 0)) {
            return 5;
        }

        if ((value.compareTo("7") == 0) || (value.compareTo("07") == 0) ||
                (value.compareTo("jul") == 0) || (value.compareTo("july") == 0)) {
            return 6;
        }

        if ((value.compareTo("8") == 0) || (value.compareTo("08") == 0) ||
                (value.compareTo("aug") == 0) || (value.compareTo("august") == 0)) {
            return 7;
        }

        if ((value.compareTo("9") == 0) || (value.compareTo("09") == 0) ||
                (value.compareTo("sep") == 0) || (value.compareTo("september") == 0)) {
            return 8;
        }

        if ((value.compareTo("10") == 0) || (value.compareTo("oct") == 0) ||
                (value.compareTo("october") == 0)) {
            return 9;
        }

        if ((value.compareTo("11") == 0) || (value.compareTo("nov") == 0) ||
                (value.compareTo("november") == 0)) {
            return 10;
        }

        if ((value.compareTo("12") == 0) || (value.compareTo("dec") == 0) ||
                (value.compareTo("december") == 0)) {
            return 11;
        }

        return 2;
    }

    /**
     * check string date with the help of regexp
     *
     * @param date string yyyy mm dd, yyyy mmm dd, yyyy mmmmm dd
     * @return true or false
     */
    public static boolean checkString(String date) {
        String REGEX = "\\d{4}/? ?(([a-zA-Z]{3,8})|\\d{1,2})/? ?\\d{2}";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
}
