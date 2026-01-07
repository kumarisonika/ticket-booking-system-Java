package org.example;

public class Seat {

    String seatId;
    String seatNumber;
    SeatType seatType;
    SeatStatus seatStatus;
    double price;

    Seat(String seatId, String seatNumber, SeatType seatType, double price) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seatStatus = SeatStatus.AVAILABLE;
        this.price = price;
    }

    public boolean isAvailable() {
        return seatStatus == SeatStatus.AVAILABLE;
    }

    public void reserve() {
        if (!isAvailable()) {
            throw new IllegalStateException(
                    "Seat " + seatNumber + " is not available hence can't be reserved."
            );
        }
//        System.out.println("Seat was reserved");
        seatStatus = SeatStatus.RESERVED;
    }

    public void book() {
        if (seatStatus != SeatStatus.RESERVED) {
            throw new IllegalStateException("Seat must be reserved before booking");
        }
        seatStatus = SeatStatus.BOOKED;
    }

    public void release() {
        seatStatus = SeatStatus.AVAILABLE;
    }
}
