package de.soniro.nursetimer;

public class DataSet {

    // TODO use lombock

    DateTime startTime;
    DateTime endTime;

    private DataSet(DateTime startTime, DateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getDuration() {
        return endTime.minus(startTime).getSeconds();
    }

    public static Builder dataSet() {
        return new Builder();
    }

    public static class Builder {
        private DateTime startTime;
        private DateTime endTime;

        public Builder withStartTime(DateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder withEndTime(DateTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public DataSet build() {
            return new DataSet(startTime, endTime);
        }
    }

}
