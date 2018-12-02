//package com.allInOne.allInOneV1.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "Seat")
//public class Seat {
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private int seatId;
//
//    private char seatName;
//
//    private int numOfSeats;
//
//    @ManyToOne
//    @JoinColumn(name="theatre_id", nullable=false)
//    private Theatre theatre;
//
//    public int getSeatId() {
//        return seatId;
//    }
//
//    public void setSeatId(int seatId) {
//        this.seatId = seatId;
//    }
//
//    public char getSeatName() {
//        return seatName;
//    }
//
//    public void setSeatName(char seatName) {
//        this.seatName = seatName;
//    }
//
//    public int getNumOfSeats() {
//        return numOfSeats;
//    }
//
//    public void setNumOfSeats(int numOfSeats) {
//        this.numOfSeats = numOfSeats;
//    }
//
//    public Theatre getTheatre() {
//        return theatre;
//    }
//
//    public void setTheatre(Theatre theatre) {
//        this.theatre = theatre;
//    }
//}
