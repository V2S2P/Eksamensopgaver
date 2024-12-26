package Opgave2_BookingSystem;

import java.awt.print.Book;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();

        User user = new User("Valdemar");

        LocalDate startDate = LocalDate.of(2024, 12, 17);
        LocalDate endDate = LocalDate.of(2025, 1, 10);

        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atStartOfDay();

        Room room = new Room("3-4",30);

        bookingSystem.addRoom(room);

        bookingSystem.showAvailable(bookingSystem, start, end, 20);
        Booking booking = bookingSystem.book(room, start, end, user);

        bookingSystem.cancel(booking);

        bookingSystem.showAvailable(bookingSystem, start, end, 20);
    }
}
