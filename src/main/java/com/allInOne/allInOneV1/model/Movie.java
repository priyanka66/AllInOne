package com.allInOne.allInOneV1.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer movieId;

    private String title;

    private Date releaseDate;

    private String language;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Movie_Genre",
            joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "genre_id") }
    )
    Set<Genre> genres = new HashSet<>();

    @ManyToMany(mappedBy = "actors")
    private Set<Actor> actors = new HashSet<>();


    @OneToMany(mappedBy="movie")
    private Set<Rating> ratings;



    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }
}
