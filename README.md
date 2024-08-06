# Meeting Room Booking System

## Overview
This project is a meeting room booking system designed to optimize room allocation based on capacity, availability, and proximity. It provides features for managing meeting rooms, handling bookings, recommending the best rooms, and dynamically updating suggestions as bookings occur. The system includes an interactive console-based user interface for ease of use.

## Here is UML Diagram for Overview

![Screenshot 2024-08-06 221102](https://github.com/user-attachments/assets/9e43788e-af89-4e1d-a273-d010ca365f80)

## Features

### Meeting Room Management
- **Add Meeting Rooms**: Add new meeting rooms to the system, specifying their capacity.
- **Remove Meeting Rooms**: Remove existing meeting rooms from the system.
- **View Meeting Rooms**: Retrieve a list of all meeting rooms and their details, including booked time ranges.

### Booking Management
- **Create Bookings**: Book a meeting room by specifying the room number, meeting time range, and number of participants.
- **Cancel Bookings**: Cancel an existing booking by providing the meeting ID.
- **View Bookings**: Retrieve a list of all current bookings, including details such as meeting ID, room number, time range, and number of participants.

### Recommendation System
- **Suggest Meeting Rooms**: Recommend the best available meeting room based on the number of participants and the desired time range.
- **Dynamic Updates**: Automatically update room suggestions as new bookings are made and capacities change.
- **Preferred Room Suggestion**: Suggest the preferred meeting room based on the weightage of the last booking.

## Usage

### Interactive Console Interface
The system features an interactive console interface that guides the user through various options. Upon launching the application, a menu is displayed with the following options:

1. **Add Meeting Room**
2. **Add Booking**
3. **Remove Booking**
4. **Recommend Room**
5. **View All Rooms**
6. **View All Bookings**
7. **Exit**

The user can select an option by entering the corresponding number.

### Example Workflow
1. **Initialize the System**: Start the application to initialize the booking manager.
2. **Add Meeting Rooms**: Add several meeting rooms with varying capacities using the console interface.
3. **Create Bookings**: Make bookings for different rooms and time ranges using the provided options.
4. **Get Recommendations**: Request recommendations for available rooms based on specific criteria.
5. **Cancel Bookings**: Cancel a booking and observe how the system updates available room recommendations.

### Menu Options
- **Add Meeting Room**: Prompts the user to enter the room number and capacity.
- **Add Booking**: Prompts the user to enter the meeting ID, room number, start time, end time, and number of participants.
- **Remove Booking**: Prompts the user to enter the meeting ID to cancel the booking.
- **Recommend Room**: Prompts the user to enter the number of participants, start time, and end time, and then suggests the best available room.
- **View All Rooms**: Displays a list of all meeting rooms and their booked time ranges.
- **View All Bookings**: Displays a list of all current bookings with their details.
- **Exit**: Exits the application.

### Console Commands
- **Clear Screen**: Clears the console screen to enhance user experience.
- **Pause for User**: Pauses the application and waits for the user to press Enter before continuing.

## Handling Edge Cases
The system includes handling for various edge cases to ensure robust performance:
- **Room Unavailability**: If a room is already booked for the desired time range, the system will not allow the booking and will inform the user that the room is unavailable.
- **Capacity Exceeded**: If the number of participants exceeds the room's capacity, the system will not allow the booking and will inform the user that the room's capacity has been exceeded.
- **Invalid Inputs**: The system validates inputs for room numbers, time ranges, and participant numbers to ensure data integrity and prevent errors.

## Files and Classes

### Main.java
- The main entry point for the application.
- Provides the interactive console interface for managing rooms and bookings.

### BookingManager.java
- Manages the list of meeting rooms and bookings.
- Handles adding, removing, and recommending rooms based on specified criteria.

### Bookings.java
- Represents a booking with details such as meeting ID, room number, time range, and number of participants.

### MeetingRooms.java
- Represents a meeting room with details such as room number, capacity, and booked time ranges.

### TimeRange.java
- Represents a time range with start and end times.
- Includes methods to check for overlapping time ranges and equality.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.
