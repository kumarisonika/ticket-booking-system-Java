package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {

        Seat s1= new Seat("seat001", "01", SeatType.REGULAR, 600);
        Seat s2= new Seat("seat002", "02", SeatType.VIP, 1200);
        Seat s3= new Seat("seat003", "03", SeatType.PREMIUM, 800);
        List<Seat> seats1 = new ArrayList<>();
        seats1.add(s1);
        seats1.add(s2);
        seats1.add(s3);

        Concert concert1 = new Concert("concert001", "Linken Park", "Bangalore", LocalDateTime.now().plusDays(10),seats1);
        ConcertTicketBookingSystem system = new ConcertTicketBookingSystem();

        system.addConcert(concert1);

        User user1 = new User("user01", "Robin", "robin@gmail.com");

        Booking booking = system.bookSeats(user1, concert1, seats1);

        System.out.println(booking.bookingId+ " "+ booking.bookingStatus + " "+ booking.user+" "+ booking.totalPrice+" " + booking.concert.artist);




    }
}
