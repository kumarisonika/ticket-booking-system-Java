package org.example;

import java.time.Duration;
import java.time.LocalDateTime;

public class Seat {
    String seatId;
    String seatNumber;
    SeatType seatType;
    SeatStatus seatStatus;
    double price;

    LocalDateTime reservedAt;
    private static final int RESERVATION_TIMEOUT_MINUTES=5;

    Seat(String seatId, String seatNumber, SeatType seatType, double price) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seatStatus = SeatStatus.AVAILABLE;
        this.price = price;
    }

    public synchronized boolean isAvailable() {
        if (seatStatus == SeatStatus.RESERVED && isReservationExpired()) {
            releaseInternal();
        }
        return seatStatus == SeatStatus.AVAILABLE;
    }

    public void reserve() {
        if (!isAvailable()) {
            throw new IllegalStateException(
                    "Seat " + seatNumber + " is not available hence can't be reserved."
            );
        }
        seatStatus = SeatStatus.RESERVED;
    }

    public synchronized void book() {
        if (seatStatus != SeatStatus.RESERVED) {
            throw new IllegalStateException("Seat must be reserved before booking");
        }
        if (isReservationExpired()) {
            releaseInternal();
            throw new IllegalStateException("Reservation expired for seat " + seatNumber);
        }
        seatStatus = SeatStatus.BOOKED;
    }

    public synchronized void release() {
        releaseInternal();
    }

    private void releaseInternal() {
        seatStatus = SeatStatus.AVAILABLE;
        reservedAt = null;
    }

    private boolean isReservationExpired() {
        if (reservedAt == null) return false;
        return Duration.between(reservedAt, LocalDateTime.now())
                .toMinutes() >= RESERVATION_TIMEOUT_MINUTES;
    }
}
