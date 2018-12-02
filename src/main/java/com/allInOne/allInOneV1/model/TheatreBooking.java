package com.allInOne.allInOneV1.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TheatreBooking")
public class TheatreBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer theatreBookingId;

    @OneToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    private Theatre theatre;

    private Date startTime;

    private Date endTime;

    private int numSeats;

    private String status;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Integer getTheatreBookingId() {
        return theatreBookingId;
    }

    public void setTheatreBookingId(Integer theatreBookingId) {
        this.theatreBookingId = theatreBookingId;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}