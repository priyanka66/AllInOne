package com.allInOne.allInOneV1.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Genre")
public class Genre {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int genreId;

    private String genre;

    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies = new HashSet<>();

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

}
