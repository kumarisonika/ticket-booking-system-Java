package org.example;

import java.time.LocalDateTime;
import java.util.List;

public class Concert {
    String concertId;
    String artist;
    String venue;
    LocalDateTime dateTime;
    List<Seat> seats;


    public Concert(String concertId, String artist, String venue, LocalDateTime dateTime, List<Seat> seats) {
        this.concertId = concertId;
        this.artist = artist;
        this.venue = venue;
        this.dateTime = dateTime;
        this.seats = seats;
    }
}
