// import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MeetingRooms {
    private int roomNo;
    private int capacity;
    private List<TimeRange> bookedTimeRanges;

    public MeetingRooms(int roomNo, int capacity) {
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.bookedTimeRanges = new ArrayList<>();
    }

    public int getRoomNo() {
        return roomNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<TimeRange> getBookedTimeRanges() {
        return bookedTimeRanges;
    }

    public void addBooking(TimeRange timeRange) {
        bookedTimeRanges.add(timeRange);
    }

    public void removeBooking(TimeRange timeRange) {
        bookedTimeRanges.remove(timeRange);
    }
}
