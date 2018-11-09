package com.allInOne.allInOneV1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.*;

@Entity
@Table(name = "Rating")
public class Rating {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int ratingId;

    @Min(0)
    @Max(5)
    private int rating;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;
//
//    @ManyToOne
//    @JoinColumn(name="user_id", nullable=true)
//    private User user;

    public Rating() {

    }
    public Rating(int rating, Movie movie) {
        this.rating = rating;
        this.movie =  movie;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @JsonIgnore
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
