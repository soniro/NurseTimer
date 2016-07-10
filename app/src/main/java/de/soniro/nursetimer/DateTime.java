package de.soniro.nursetimer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

    private Date date;

    private DateTime(Date date) {
        this.date = date;
    }

    public static DateTime now() {
        return DateTime.ofMillis(System.currentTimeMillis());
    }

    public static DateTime ofMillis(long millis) {
        return new DateTime(new Date(millis));
    }

    public long getMillis() {
        return date.getTime();
    }

    public DateTime minus(DateTime dateTime) {
        return DateTime.ofMillis(getMillis() - dateTime.getMillis());
    }

    public DateTime minus(long value, TimeUnit unit) {
        return DateTime.ofMillis(getMillis() - value * unit.getFactor());
    }

    public DateTime plus(long value, TimeUnit unit) {
        return DateTime.ofMillis(getMillis() + value * unit.getFactor());
    }

    @Override
    public String toString() {
        return new SimpleDateFormat("dd.MM.yyyy hh:mm").format(date);
    }

    public Long as(TimeUnit timeUnit) {
        return Math.round(Double.valueOf(getMillis()) / timeUnit.getFactor());
    }
}
