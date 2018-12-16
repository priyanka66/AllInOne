package com.allInOne.allInOneV1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    private String movieImage;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Movie_Genre",
            joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "genre_id") }
    )
    Set<Genre> genres = new HashSet<>();

    @ManyToMany(mappedBy = "movies")
    private Set<Actor> actors = new HashSet<>();


    @OneToMany(mappedBy="movie")
    private List<Rating> ratings;


    @ManyToMany(mappedBy = "movies")
    private Set<Theatre> theatres = new HashSet<>();

    public Movie() {

    }
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

    public String getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(String img) {
        this.movieImage = img;
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

    public void setActors(Actor actor) {

        this.actors.add(actor);
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Rating ratings) {
        this.ratings.add(ratings);
    }

    @JsonIgnore
    public Set<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(Theatre theatre) {
        if (!this.theatres.contains(theatre)) {
            this.theatres.add(theatre);
        }
    }
}
