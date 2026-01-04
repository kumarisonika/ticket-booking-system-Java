package org.example;
import org.example.Seat;
import java.util.HashMap;
import java.util.Map;

public class Event {
    private final int eventId;
    private final Map<Integer, Seat> seats = new HashMap<>();

    public Event(int eventId, int totalSeats){
        this.eventId= eventId;
        for(int i=1; i<= totalSeats; i++){
            seats.put(i, new Seat(i));
        }
    }

    public int getEventId(){
        return eventId;
    }

    public Seat getSeat(int seatNumber){
        return seats.get(seatNumber);
    }
}