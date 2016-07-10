package de.soniro.nursetimer;

import org.junit.Test;

import static de.soniro.nursetimer.TimeUnit.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TimeUnitTest {

    @Test
    public void shouldTransformDateTimeToSeconds() {
        assertThat(DateTime.ofMillis(2000).as(SECONDS), is(2L));
    }

    @Test
    public void shouldRoundDateWhenTransforming() {
        assertThat(DateTime.ofMillis(2499).as(SECONDS), is(2L));
    }

    @Test
    public void shouldRoundUpDateWhenTransforming() {
        assertThat(DateTime.ofMillis(2500).as(SECONDS), is(3L));
    }

    @Test
    public void shouldTransformDateTimeToMinutes() {
        assertThat(DateTime.ofMillis(60 * 3000).as(MINUTES), is(3L));
    }

    @Test
    public void shouldTransformDateTimeToHours() {
        assertThat(DateTime.ofMillis(60 * 60 * 1000).as(HOURS), is(1L));
    }

    @Test
    public void shouldTransformDateTimeToDays() {
        assertThat(DateTime.ofMillis(24 * 60 * 60 * 5000).as(DAYS), is(5L));
    }

}
