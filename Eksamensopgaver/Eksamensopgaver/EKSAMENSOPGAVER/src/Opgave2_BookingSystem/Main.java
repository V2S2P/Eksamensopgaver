package Opgave2_BookingSystem;

import java.awt.print.Book;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();

        User user = new User("Valdemar");
        User user1 = new User("Oliver");

        LocalDate startDate = LocalDate.of(2024, 12, 17);
        LocalDate endDate = LocalDate.of(2025, 1, 10);

        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atStartOfDay();

        Room room = new Room("3-4",30);
        Room room1 = new Room("3-5", 30);
        Room room2 = new Room("3-6",30);

        bookingSystem.addRoom(room);
        bookingSystem.addRoom(room1);
        bookingSystem.addRoom(room2);

        bookingSystem.showAvailable(bookingSystem, start, end, 20);
        Booking booking = bookingSystem.book(room, start, end, user);

        bookingSystem.showAvailable(bookingSystem, start, end, 30);
        Booking booking1 = bookingSystem.book(room1, start, end, user1);

        bookingSystem.cancel(booking);
        //bookingSystem.findAvailable(31, start, end);

        //bookingSystem.showAvailable(bookingSystem, start, end, 30);
    }
}
