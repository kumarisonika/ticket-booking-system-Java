package org.example;

import java.util.ArrayList;
import java.util.List;

public class ConcertTicketBookingSystem {
    private List<Concert> concerts = new ArrayList<>();
    private  List<Booking> bookings = new ArrayList<>();

    public void addConcert(Concert concert) {
        concerts.add(concert);
    }

    public Booking bookSeats(User user, Concert concert, List<Seat> seats){
        double total=0;

        for (Seat seat: seats){
            seat.book();
            total+= seat.price;
        }

        Booking booking = new Booking();
        booking.user= user;
        booking.concert= concert;
        booking.totalPrice = total;
        booking.bookingStatus= BookingStatus.PENDING;

        booking.confirm();
        bookings.add(booking);
        return booking;


    }
}
