package Opgave2_BookingSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {
    private Room room;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private User user;

    public Booking(Room room, LocalDateTime startDate, LocalDateTime endDate, User user){
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
    }
    public Room getRoom(){
        return room;
    }
    public LocalDateTime getStartDate(){
        return startDate;
    }
    public LocalDateTime getEndDate(){
        return endDate;
    }
    public User getUser(){
        return user;
    }
    @Override
    public String toString(){
        return "Room: " + room.getName();
    }
}
