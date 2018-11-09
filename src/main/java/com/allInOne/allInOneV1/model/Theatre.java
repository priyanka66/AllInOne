package com.allInOne.allInOneV1.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Theatre")
public class Theatre {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int theatreId;

    private String theatreName;

    private  double latitute;

    private  double longitude;

    @OneToMany(mappedBy="theatre")
    private List<Seat> seats;

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public double getLatitute() {
        return latitute;
    }

    public void setLatitute(double latitute) {
        this.latitute = latitute;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
