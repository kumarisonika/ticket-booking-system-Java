package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ConcertTicketBookingSystem {
    private List<Concert> concerts = new ArrayList<>();
    private  List<Booking> bookings = new ArrayList<>();

    public void addConcert(Concert concert) {
        concerts.add(concert);
    }

    public Booking bookSeats(User user, Concert concert, List<Seat> seats){
        double total=0;

        for (Seat seat: seats){
            seat.reserve();
            total+= seat.price;
        }

        Booking booking = new Booking(UUID.randomUUID().toString(), user,concert,seats,total);

        booking.confirm();
        bookings.add(booking);
        return booking;
    }
}
