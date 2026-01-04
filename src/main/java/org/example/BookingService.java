package org.example;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    public Booking createBooking(int bookingId, Event event, List<Integer> seatNumbers){
        List<Seat> seatsToBook = new ArrayList<>();

        for(int seatNumber: seatNumbers){
            Seat seat = event.getSeat(seatNumber);

            if(seat==null){
                throw new IllegalArgumentException("Seat not found: "+seatNumber);
            }

            if(!seat.isAvailable()){
                throw new IllegalStateException("Seat already booked: "+ seatNumber);
            }
            seatsToBook.add(seat);
        }

        for (Seat seat: seatsToBook){
            seat.book();
        }

        Booking booking = new Booking(bookingId, event, seatsToBook);
        booking.confirm();

        return booking;
    }
}
