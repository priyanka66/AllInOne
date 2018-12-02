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

    private  double latitude;

    private  double longitude;

    private int numSeats;

    private int availableSeats;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Movie_Theatre",
            joinColumns = { @JoinColumn(name = "theatre_id") },
            inverseJoinColumns = { @JoinColumn(name = "movie_id") }
    )
    Set<Movie> movies = new HashSet<>();


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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Movie movie) {
        if (!this.movies.contains(movie)) {
            this.movies.add(movie);
        }
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

}
