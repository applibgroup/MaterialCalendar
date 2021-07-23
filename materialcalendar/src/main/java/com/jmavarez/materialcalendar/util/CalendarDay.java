package com.jmavarez.materialcalendar.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * CalendarDay
 */
public final class CalendarDay implements Serializable {
    private final int day;
    private final int month;
    private final int year;

    private transient Calendar calendar;

    private transient Date date;

    public static CalendarDay today() {
        return from(CalendarUtils.getInstance());
    }

    /**
     * CalenderDay Constructor
     *
     * @param day - date of the day
     * @param month - month of the day
     * @param year - year of the day
     */
    public CalendarDay(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @NotNull
    public static CalendarDay from(int day, int month, int year) {
        return new CalendarDay(day, month, year);
    }

    /**
     * CalenderDay
     * @param calendar - calendar Instance
     * @return - returns
     */
    public static CalendarDay from(@Nullable Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        return from(
                CalendarUtils.getDay(calendar),
                CalendarUtils.getMonth(calendar),
                CalendarUtils.getYear(calendar)
        );
    }

    /**
     * CalendarDay
     * @param date - Date Instance
     * @return - returns
     */
    public static CalendarDay from(@Nullable Date date) {
        if (date == null) {
            return null;
        }
        return from(CalendarUtils.getInstance(date));
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    /**
     * Date - get function
     * @return - returns
     */
    @NotNull
    public Date getDate() {
        if (date == null) {
            date = getCalendar().getTime();
        }
        return date;
    }

    /**
     * get Calendar Instance
     * @return - returns
     */
    @NotNull
    public Calendar getCalendar() {
        if (calendar == null) {
            calendar = CalendarUtils.getInstance();
            copyTo(calendar);
        }
        return calendar;
    }

    public void copyTo(@NotNull Calendar calendar) {
        calendar.clear();
        calendar.set(year, month, day);
    }

    @Override
    public String toString() {
        return "CalendarDay [" + day + "-" + month + "-" + year + "]";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * equals - checks whether they are equal or not
     * @param o - testing object
     * @return - returns bool
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CalendarDay that = (CalendarDay) o;

        return day == that.day && month == that.month && year == that.year;
    }

    public boolean equalsMonth(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CalendarDay that = (CalendarDay) o;

        return month == that.month && year == that.year;
    }
}
