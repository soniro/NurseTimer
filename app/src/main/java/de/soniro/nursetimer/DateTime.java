package de.soniro.nursetimer;

import java.util.Date;

import static de.soniro.nursetimer.DateTime.TimeUnit.SECONDS;

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

    public Long getSeconds() {
        return getMillis() / SECONDS.getFactor();
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

    public enum TimeUnit {
        SECONDS(1000),
        MINUTES(60 * 1000);

        private long factor;

        TimeUnit(long factor) {
            this.factor = factor;
        }

        public long getFactor() {
            return factor;
        }
    }
}
