package de.soniro.nursetimer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import static lombok.AccessLevel.PRIVATE;

@Builder
@Getter
@AllArgsConstructor(access = PRIVATE)
public class DataSet {

    private String id;
    private Position position;
    private DateTime startTime;
    private DateTime endTime;

    public Long getDuration(TimeUnit timeUnit) {
        return endTime.minus(startTime).as(timeUnit);
    }

}
