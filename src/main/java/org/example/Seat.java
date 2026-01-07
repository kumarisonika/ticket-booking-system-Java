package org.example;

public class Seat {
        String seatId;
        String seatNumber;
        SeatType seatType;
        SeatStatus seatStatus;
        double price;

        Seat(String seatId, String seatNumber, SeatType seatType, double price){
            this.seatId = seatId;
            this.seatNumber = seatNumber;
            this.seatType=seatType;
            this.seatStatus = SeatStatus.AVAILABLE;
            this.price= price;
        }

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
