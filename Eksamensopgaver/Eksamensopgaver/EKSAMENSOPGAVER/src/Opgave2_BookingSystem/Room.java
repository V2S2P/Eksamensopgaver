package Opgave2_BookingSystem;
import java.util.ArrayList;
import java.util.List;
public class Room {
    private String name;
    private int capacity;
    private List<Booking> bookingList;

    public Room(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        bookingList = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }
    public String getName(){
        return name;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void addBooking(Booking booking){
        bookingList.add(booking);
    }
    public void removeBooking(Booking booking){
        bookingList.remove(booking);
    }
    @Override
    public String toString(){
        return "Room: " + getName();
    }
}
