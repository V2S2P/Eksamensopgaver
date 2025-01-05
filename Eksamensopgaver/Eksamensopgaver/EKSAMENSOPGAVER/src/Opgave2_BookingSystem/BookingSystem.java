package Opgave2_BookingSystem;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class BookingSystem {
    private List<Room> rooms;
    public BookingSystem(){
        rooms = new ArrayList<>();
    }
    public void addRoom(Room room){
        rooms.add(room);
    }

    public boolean isAvailable(Room room, LocalDateTime start, LocalDateTime end){
        for (Booking booking : room.getBookingList()){
            //Checks if a requested start time overlaps with an existing booking's end time and vice versa.
            if (start.isBefore(booking.getEndDate()) && end.isAfter(booking.getStartDate())){
                //If both conditions are true we return false to signify the room not being available.
                return false;
            }
        }
        return true;
    }
    public List<Room> findAvailable(int capacity, LocalDateTime start, LocalDateTime end) {
        List<Room> availableRooms = new ArrayList<>();
            for (Room room : rooms) {
                if (room.getCapacity() >= capacity && isAvailable(room, start, end)) {
                    availableRooms.add(room);
                }
            }
            if (availableRooms.isEmpty()){
                System.out.println("No rooms available with a capacity of " + capacity);
            }
        return availableRooms;
    }
    public Booking book(Room room, LocalDateTime start, LocalDateTime end, User user){
        if (room != null){
            System.out.println("Booking successful: " + room.getName() + user.getName());
        }else {
            System.out.println("Room is not available");
        }
        if (start.isAfter(end)){
            throw new IllegalArgumentException("Start time must be before end time");
        }
        //To ensure that the room variable isn't null before we reach the rest of the code.
        assert room != null;
        if (isAvailable(room, start, end)){
            Booking booking = new Booking(room, start, end, user);
            room.addBooking(booking);
            return booking;
        }
        return null;
    }
    public void cancel(Booking booking){
        booking.getRoom().removeBooking(booking);
        System.out.println(booking.getRoom() + " has been canceled");

    }
    public void showAvailable(BookingSystem bookingSystem, LocalDateTime start, LocalDateTime end, int capacity){
        List<Room> availableRooms = bookingSystem.findAvailable(capacity, start, end);
        for (Room r : availableRooms){
            System.out.println("Available room: " + r.getName() + "-" + r.getCapacity());
        }
    }
    public void createRooms(int amount, int capacity){
        //ArrayList<Room> rooms = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Room room = new Room("Room " + i, capacity);
            addRoom(room);
        }
    }
}
