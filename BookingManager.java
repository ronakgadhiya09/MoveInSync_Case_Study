import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<MeetingRooms> meetingRooms;
    private List<Bookings> bookings;

    public BookingManager() {
        this.meetingRooms = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public void addMeetingRoom(MeetingRooms meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public List<MeetingRooms> getAllMeetingRooms() {
        return meetingRooms;
    }

    public List<Bookings> getAllBookings() {
        return bookings;
    }

    public void addBooking(Bookings booking) {
        for (MeetingRooms room : meetingRooms) {
            if (room.getRoomNo() == booking.getRoomNo() && room.getCapacity() >= booking.getNoOfParticipants()) {
                room.addBooking(booking.getTimeRange());
                bookings.add(booking);
                System.out.println("Booking added successfully.");
                return;
            }
        }
        System.out.println("Room not available or capacity exceeded.");
    }

    public void removeBooking(int meetingId) {
        Bookings bookingToRemove = null;
        for (Bookings booking : bookings) {
            if (booking.getMeetingId() == meetingId) {
                bookingToRemove = booking;
                break;
            }
        }

        if (bookingToRemove != null) {
            for (MeetingRooms room : meetingRooms) {
                if (room.getRoomNo() == bookingToRemove.getRoomNo()) {
                    room.removeBooking(bookingToRemove.getTimeRange());
                    bookings.remove(bookingToRemove);
                    System.out.println("Booking removed successfully.");
                    return;
                }
            }
        } else {
            System.out.println("Booking not found.");
        }
    }

    public MeetingRooms recommendRoom(int noOfParticipants, LocalDateTime startTime, LocalDateTime endTime) {
        for (MeetingRooms room : meetingRooms) {
            if (room.getCapacity() >= noOfParticipants) {
                boolean available = true;
                for (TimeRange range : room.getBookedTimeRanges()) {
                    if (startTime.isBefore(range.getEndTime()) && endTime.isAfter(range.getStartTime())) {
                        available = false;
                        break;
                    }
                }
                if (available) {
                    return room;
                }
            }
        }
        return null;
    }
}
