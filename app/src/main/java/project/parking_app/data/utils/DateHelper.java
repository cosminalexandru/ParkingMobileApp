package project.parking_app.data.utils;

import java.util.Calendar;

import static java.util.Calendar.DAY_OF_WEEK;

public class DateHelper {
    public static boolean isItBusyPeriod() {

        Calendar c = Calendar.getInstance();
        c.setTime(Calendar.getInstance().getTime());
        return c.get(DAY_OF_WEEK) != Calendar.SATURDAY && c.get(DAY_OF_WEEK) != Calendar.SUNDAY;
    }
}
