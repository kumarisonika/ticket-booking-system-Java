package org.example;

public class Seat {
        String seatId;
        String seatNumber;
        SeatType seatType;
        SeatStatus seatStatus;
        double price;

        public boolean isAvailable(){
            return seatStatus == SeatStatus.AVAILABLE;
        }

        public void book(){
            if(seatStatus!=SeatStatus.AVAILABLE){
                throw new IllegalStateException("Seat already booked");
            }
            seatStatus=SeatStatus.BOOKED;
        }

        public void release(){
            seatStatus=SeatStatus.AVAILABLE;
        }
}
