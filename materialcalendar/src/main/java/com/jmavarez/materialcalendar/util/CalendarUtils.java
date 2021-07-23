package com.jmavarez.materialcalendar.util;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;
import java.util.Date;

/**
 * CalendarUtils utility class.
 */
public class CalendarUtils {

    private CalendarUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * get Calendar Instance.
     *
     * @param date - date argument.
     * @return - returns Calendar object.
     */
    public static Calendar getInstance(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        copyDateTo(calendar, calendar);
        return calendar;
    }

    /**
     * get Calendar Instance.
     *
     * @return -  returns Calendar object.
     */
    public static Calendar getInstance() {
        Calendar calendar = Calendar.getInstance();
        copyDateTo(calendar, calendar);
        return calendar;
    }

    /**
     * setToFirstDay.
     *
     * @param calendar - calendar.
     */
    public static void setToFirstDay(Calendar calendar) {
        int year = getYear(calendar);
        int month = getMonth(calendar);
        calendar.clear();
        calendar.set(year, month, 1);
    }

    /**
     * copyToDate.
     *
     * @param from - from Date.
     * @param to -to Date.
     */
    public static void copyDateTo(Calendar from, Calendar to) {
        int year = getYear(from);
        int month = getMonth(from);
        int day = getDay(from);
        to.clear();
        to.set(year, month, day);
    }

    /**
     * getDay.
     *
     * @param c - c.
     * @return - returns.
     */
    public static int getDay(Calendar c) {
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * getDayOfWeek.
     *
     * @param c - c.
     * @param startOnSunday - startOn sunday.
     * @return - return.
     */
    public static int getDayOfWeek(Calendar c, boolean startOnSunday) {
        return getConvertedDayOfWeek(c.get(Calendar.DAY_OF_WEEK), startOnSunday);
    }

    /**
     * get month.
     *
     * @param c - calendar.
     * @return - return.
     */
    public static int getMonth(Calendar c) {
        return c.get(Calendar.MONTH);
    }

    /**
     * get Year.
     *
     * @param c - calendar.
     * @return - return.
     */
    public static int getYear(Calendar c) {
        return c.get(Calendar.YEAR);
    }

    /**
     * getEndOfMonth.
     *
     * @param c - calendar.
     * @return - return.
     */
    public static int getEndOfMonth(Calendar c) {
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * getConvertedDayOfWeek.
     *
     * @param day - day.
     * @param startOnSunday - startOnSunday.
     * @return - return.
     */
    public static int getConvertedDayOfWeek(int day, boolean startOnSunday) {
        if (startOnSunday) {
            return day;
        }
        return day == 1 ? 7 : day - 1;
    }

    /**
     * Day Class.
     */
    public static class Day {
        private Integer mDay;

        /**
         * Day Constructor.
         *
         * @param day - day.
         */
        public Day(@NotNull Integer day) {
            this.mDay = null;
            if (day.intValue() < 1 || day.intValue() > 7) {
                throw new IllegalArgumentException("Day must be between 1 and 7");
            }
            this.mDay = day;
        }

        public Integer toInteger() {
            return this.mDay;
        }

        /**
         * getShortName.
         */
        public String getShortName() {
            String string;
            switch (this.mDay) {
                case 1:
                    string = "M";
                    break;
                case 2:
                case 4:
                    string = "T";
                    break;
                case 3:
                    string = "W";
                    break;
                case 5:
                    string = "F";
                    break;
                case 6:
                case 7:
                    string = "S";
                    break;
                default:
                    return "getDay";
            }
            return string;

        }
    }
}

