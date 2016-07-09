package de.soniro.nursetimer;

import org.junit.Test;

import static de.soniro.nursetimer.DateTime.TimeUnit.MINUTES;
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

        assertThat(dataset.getDuration(), is(Long.valueOf(43 * 60)));
    }


}
