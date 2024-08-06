import java.time.LocalDateTime;

public class TimeRange {
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public TimeRange(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public boolean overlaps(TimeRange other) {
        return startTime.isBefore(other.endTime) && endTime.isAfter(other.startTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeRange timeRange = (TimeRange) o;
        return startTime.equals(timeRange.startTime) && endTime.equals(timeRange.endTime);
    }
}
