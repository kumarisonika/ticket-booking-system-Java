package org.example;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    String bookingId;
    User user;
    Concert concert;
    List<Seat> seats;
    double totalPrice;
    BookingStatus bookingStatus;

    public void confirm(){
        bookingStatus = BookingStatus.CONFIRMED;
    }

    public void cancel(){
        for (Seat seat: seats){
            seat.release();
        }
        bookingStatus= BookingStatus.CANCELLED;
    }

}
