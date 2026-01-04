package org.example;

import java.util.List;

public class Booking {
    private final int bookingId;
    private final Event event;
    private final List<Seat> seats;
    private BookingStatus status;

    public Booking(int bookingId, Event event, List<Seat> seats){
        this.bookingId= bookingId;
        this.event=event;
        this.seats=seats;
        this.status=BookingStatus.CREATED;
    }

    public void confirm(){
        this.status= BookingStatus.CONFIRMED;
    }

    public BookingStatus getStatus(){
        return status;
    }

    public List<Seat> getSeats(){
        return seats;
    }
}
