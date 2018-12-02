package com.allInOne.allInOneV1.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Actor")
public class Actor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String firstName;

    private String lastName;

    private char gender;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Actor_Movie",
            joinColumns = { @JoinColumn(name = "actor_id") },
            inverseJoinColumns = { @JoinColumn(name = "movie_id") }
    )
    Set<Movie> movies = new HashSet<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @JsonIgnore
    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Movie movie) {
        if (!this.movies.contains(movie)) {
            this.movies.add(movie);
        }
    }
}
