package com.yaroslav;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

/**
 * Created by Yaroslav on 18.05.2015.
 */
public class SuperCalendar {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int week;

        int month;

        int year;

        int day;

        Calendar calendar;

        int dayOfWeek;

        int countDayOfMonth;

        int dayOfMonthBefore;

        String yearMonthDay;

        while (true) {

            if ((args != null) && ((args.length == 3) || (args.length == 1))) {
                if ((args.length == 1) && (args[0].contains("/")) && !(args.length == 3)) {
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

            ArrayList<Integer> yMDList = getYearMonthDay(yearMonthDay);

            if (yMDList == null) {
                System.out.println("Oooops.. :(");
                continue;
            }

            if (yMDList.size() != 3) {
                System.out.println("You must enter 3 parameter year month and day\n");
                continue;
            }

            year = yMDList.get(0);
            month = yMDList.get(1);
            day = yMDList.get(2);

            calendar = new GregorianCalendar(year, month, day);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            countDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

            dayOfMonthBefore = getCountDeys(calendar);
            int countWeek = getCountWeeks(calendar);

            int numberDay = 1;

            System.out.println("\u001B[32m\tSun\u001B[34m\tMon\tTue\tWed\tThu\tFri\u001B[32m\tSat\u001B[30m");

            for (int numberWeek = 1; numberWeek <= countWeek; numberWeek++) {
                if (numberWeek == 1) {
                    numberDay = 0;
                }
        
                week = 1;

                while (week <= 7) {
                    numberDay += 1;

                    if (numberDay <= dayOfWeek) {
                        System.out.print("\u001B[33m" + "\t" +
                                String.valueOf(dayOfMonthBefore - dayOfWeek + numberDay) +
                                "\u001B[30m");
                    } else {
                        if ((numberDay - dayOfWeek) <= countDayOfMonth) {
                            if ((numberDay - dayOfWeek) == day) {
                                System.out.print("\u001B[31m\t" + String.valueOf(numberDay - dayOfWeek) + "\u001B[30m");
                            } else {
                                if ((numberDay % 6) == 0 && (numberWeek == 6)) {
                                    System.out.print("\u001B[32m" + "\t" +
                                            String.valueOf(numberDay - dayOfWeek) +
                                            "\u001B[30m");
                                    week++;
                                    continue;
                                } 

                                if ((numberDay % 6) == numberWeek) {
                                    System.out.print("\u001B[32m" + "\t" +
                                            String.valueOf(numberDay - dayOfWeek) +
                                            "\u001B[30m");
                                    week++;
                                    continue;
                                } 

                                if ((numberDay % 7) == 0) {
                                    System.out.print("\u001B[32m" + "\t" +
                                            String.valueOf(numberDay - dayOfWeek) +
                                            "\u001B[30m");
                                    week++;
                                    continue;
                                }

                                System.out.print("\t" + String.valueOf(numberDay - dayOfWeek));
                            }
                        } else {
                            System.out.print("\u001B[33m" + "\t" +
                                    String.valueOf(numberDay - countDayOfMonth - dayOfWeek) +
                                    "\u001B[30m");
                        }
                    }

                    week++;
                }
                System.out.println("\n");
            }

            System.out.println("Enter stop for exit");

            yearMonthDay = in.nextLine();

            if (yearMonthDay.contains("stop")) {
                break;
            }
        }

    }

    /**
     * get year month day from string
     * @param val string contain year month day or empty string
     * @return list
     */
    public static ArrayList<Integer> getYearMonthDay(String val) {
        ArrayList<Integer> paramList = new ArrayList<Integer>();

        if ((val.length() == 0) || (val == null)) {
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
            (value.compareTo("apr") == 0) || (value.compareTo("april") == 0)){
            return 3;
        }

        if ((value.compareTo("5") == 0) || (value.compareTo("05") == 0) ||
            (value.compareTo("may") == 0)) {
            return 4;
        }

        if ((value.compareTo("6") == 0) || (value.compareTo("06") == 0) ||
            (value.compareTo("jun") == 0) || (value.compareTo("june") == 0)){
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
            (value.compareTo("december") == 0))  {
            return 11;
        }

        return 2;
    }

    /**
     * check string date with the help of regexp
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
