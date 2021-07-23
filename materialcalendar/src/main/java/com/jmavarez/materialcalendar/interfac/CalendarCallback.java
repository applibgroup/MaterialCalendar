package com.jmavarez.materialcalendar.interfac;

import com.jmavarez.materialcalendar.util.CalendarDay;

import java.util.ArrayList;
import java.util.Date;

public interface CalendarCallback {
    Date getDateSelected();

    ArrayList<CalendarDay> getEvents();

    boolean getIndicatorsVisible();
}