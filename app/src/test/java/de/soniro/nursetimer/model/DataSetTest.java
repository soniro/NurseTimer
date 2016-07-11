package de.soniro.nursetimer.model;

import org.junit.Test;

import static de.soniro.nursetimer.model.TimeUnit.MINUTES;
import static de.soniro.nursetimer.model.TimeUnit.SECONDS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DataSetTest {

    @Test
    public void shouldReturnTheDurationOfADataSetInSeconds() {
        DateTime startTime = DateTime.ofMillis(System.currentTimeMillis());

        DataSet dataset = DataSet.builder()
                .startTime(startTime)
                .endTime(startTime.plus(43, MINUTES))
                .build();

        assertThat(dataset.getDuration(SECONDS), is(Long.valueOf(43 * 60)));
    }


}
