package org.example;
import java.util.List;

public class Booking {
    String bookingId;
    User user;
    Concert concert;
    List<Seat> seats;
    double totalPrice;
    BookingStatus bookingStatus;

    Booking(String bookingId, User user, Concert concert, List<Seat> seats, double totalPrice){
        this.bookingId = bookingId;
        this.user= user;
        this.concert=concert;
        this.seats=seats;
        this.totalPrice=totalPrice;
        this.bookingStatus= BookingStatus.PENDING;
    }

    public void confirm(){
        for (Seat seat: seats){
            seat.book();
        }
        bookingStatus = BookingStatus.CONFIRMED;
        System.out.println("Booking confirmed for "+ this.user.name);
    }

    public void cancel(){
        for (Seat seat: seats){
            seat.release();
        }
        bookingStatus= BookingStatus.CANCELLED;
        System.out.println("Booking cancelled for "+ this.user.name);
    }

}
