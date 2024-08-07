import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BookingManager bookingManager = new BookingManager();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void main(String[] args) {
        while (true) {
            clearScreen();
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addMeetingRoom();
                    break;
                case 2:
                    addBooking();
                    break;
                case 3:
                    removeBooking();
                    break;
                case 4:
                    recommendRoom();
                    break;
                case 5:
                    viewAllRooms();
                    break;
                case 6:
                    viewAllBookings();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            pauseForUser();
        }
    }

    private static void showMenu() {
        System.out.println("1. Add Meeting Room");
        System.out.println("2. Add Booking");
        System.out.println("3. Remove Booking");
        System.out.println("4. Recommend Room");
        System.out.println("5. View All Rooms");
        System.out.println("6. View All Bookings");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addMeetingRoom() {
        System.out.print("Enter Room Number: ");
        int roomNo = scanner.nextInt();
        System.out.print("Enter Room Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        bookingManager.addMeetingRoom(new MeetingRooms(roomNo, capacity));
        System.out.println("Meeting room added successfully.");
    }

    private static void addBooking() {
        System.out.print("Enter Meeting ID: ");
        int meetingId = scanner.nextInt();
        System.out.print("Enter Room Number: ");
        int roomNo = scanner.nextInt();
        System.out.print("Enter Start Time (yyyy-MM-dd HH:mm): ");
        String startTimeStr = scanner.next() + " " + scanner.next();
        System.out.print("Enter End Time (yyyy-MM-dd HH:mm): ");
        String endTimeStr = scanner.next() + " " + scanner.next();
        System.out.print("Enter Number of Participants: ");
        int noOfParticipants = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        LocalDateTime startTime = LocalDateTime.parse(startTimeStr, formatter);
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr, formatter);

        Bookings booking = new Bookings(meetingId, roomNo, startTime, endTime, noOfParticipants);
        bookingManager.addBooking(booking);
    }

    private static void removeBooking() {
        System.out.print("Enter Meeting ID to Remove: ");
        int meetingId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        bookingManager.removeBooking(meetingId);
    }

    private static void recommendRoom() {
        System.out.print("Enter Number of Participants: ");
        int noOfParticipants = scanner.nextInt();
        System.out.print("Enter Start Time (yyyy-MM-dd HH:mm): ");
        String startTimeStr = scanner.next() + " " + scanner.next();
        System.out.print("Enter End Time (yyyy-MM-dd HH:mm): ");
        String endTimeStr = scanner.next() + " " + scanner.next();
        scanner.nextLine();  // Consume newline

        LocalDateTime startTime = LocalDateTime.parse(startTimeStr, formatter);
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr, formatter);

        MeetingRooms recommendedRoom = bookingManager.recommendRoom(noOfParticipants, startTime, endTime);
        if (recommendedRoom != null) {
            System.out.println("Recommended Room No: " + recommendedRoom.getRoomNo());
        } else {
            System.out.println("No suitable room available.");
        }
    }

    private static void viewAllRooms() {
        List<MeetingRooms> rooms = bookingManager.getAllMeetingRooms();
        if (rooms.isEmpty()) {
            System.out.println("No meeting rooms available.");
        } else {
            System.out.println("Meeting Rooms:");
            for (MeetingRooms room : rooms) {
                System.out.println("Room No: " + room.getRoomNo() + ", Capacity: " + room.getCapacity());
                if (room.getBookedTimeRanges().isEmpty()) {
                    System.out.println("  No bookings.");
                } else {
                    System.out.println("  Booked Time Ranges:");
                    for (TimeRange range : room.getBookedTimeRanges()) {
                        System.out.println("    " + range);
                    }
                }
            }
        }
    }

    private static void viewAllBookings() {
        List<Bookings> bookings = bookingManager.getAllBookings();
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
        } else {
            System.out.println("Bookings:");
            for (Bookings booking : bookings) {
                System.out.println("Meeting ID: " + booking.getMeetingId() +
                        ", Room No: " + booking.getRoomNo() +
                        ", Start Time: " + booking.getStartTime().format(formatter) +
                        ", End Time: " + booking.getEndTime().format(formatter) +
                        ", Participants: " + booking.getNoOfParticipants());
            }
        }
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error clearing the console.");
        }
    }

    private static void pauseForUser() {
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }
}
