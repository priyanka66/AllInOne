package com.allInOne.allInOneV1.repository;

import com.allInOne.allInOneV1.model.Movie;

import java.util.List;

public interface MovieRepositoryCustom {
    List<Movie> getMovieNamesLike(String title);
    List<Movie> getTopMovies(int count);
}
