package org.example;

public class Seat {
    private final int seatNumber;
    private SeatStatus status;

    public Seat(int seatNumber){
        this.seatNumber= seatNumber;
        this.status = SeatStatus.AVAILABLE;
    }

    public int getSeatNumber(){
        return seatNumber;
    }

    public SeatStatus getStatus(){
        return status;
    }

    public boolean isAvailable(){
        return status==SeatStatus.AVAILABLE;
    }

    public void book(){
        status=SeatStatus.BOOKED;
    }
}
