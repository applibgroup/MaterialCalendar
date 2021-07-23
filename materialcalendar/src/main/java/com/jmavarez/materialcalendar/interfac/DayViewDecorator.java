package com.jmavarez.materialcalendar.interfac;

import com.jmavarez.materialcalendar.DayView;
import com.jmavarez.materialcalendar.util.CalendarDay;

public interface DayViewDecorator {
    boolean shouldDecorate(CalendarDay day);

    void decorate(DayView view);
}
