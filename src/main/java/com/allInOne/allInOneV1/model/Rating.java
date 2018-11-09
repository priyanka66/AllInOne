package com.allInOne.allInOneV1.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Rating")
public class Rating {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int ratingId;

    private int rating;

    @ManyToOne
    @JoinColumn(name="movie_id", nullable=false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;


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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
