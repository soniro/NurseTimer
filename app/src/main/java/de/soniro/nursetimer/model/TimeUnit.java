package de.soniro.nursetimer.model;

public enum TimeUnit {
    SECONDS(1000),
    MINUTES(60 * 1000),
    HOURS(60 * 60 * 1000),
    DAYS(24 * 60 * 60 * 1000);

    private long factor;

    TimeUnit(long factor) {
        this.factor = factor;
    }

    public long getFactor() {
        return factor;
    }
}