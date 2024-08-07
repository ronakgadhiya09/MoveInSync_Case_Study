import java.time.LocalDateTime;

public class Bookings {
    private int meetingId;
    private int roomNo;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int noOfParticipants;

    public Bookings(int meetingId, int roomNo, LocalDateTime startTime, LocalDateTime endTime, int noOfParticipants) {
        this.meetingId = meetingId;
        this.roomNo = roomNo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.noOfParticipants = noOfParticipants;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public int getNoOfParticipants() {
        return noOfParticipants;
    }

    public TimeRange getTimeRange() {
        return new TimeRange(startTime, endTime);
    }
}
