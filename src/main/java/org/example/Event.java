package org.example;

public class Event {
    int eventId;
    String name;
    String dateTime;
    String venue;
    int seats;

    Event(int eventId, String name, String dateTime, String venue, int seats){
        this.eventId= eventId;
        this.name=name;
        this.dateTime=dateTime;
        this.venue=venue;
        this.seats=seats;
    }
}
