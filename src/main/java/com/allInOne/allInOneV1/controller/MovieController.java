package com.allInOne.allInOneV1.controller;

import com.allInOne.allInOneV1.model.Movie;
import com.allInOne.allInOneV1.model.Rating;
import com.allInOne.allInOneV1.repository.MovieRepository;
import com.allInOne.allInOneV1.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping(path="/movie")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @RequestMapping(path="/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovie(@RequestBody Movie newMovie) {
        movieRepository.save(newMovie);
    }

    @RequestMapping(path="/{movieId}/rating", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovieRating(@PathVariable(value = "movieId") int movieId, @RequestBody Rating rating) {
        Movie movie = verifyMovie(movieId);
        System.out.print("movies --- " + movie.getMovieId());
        System.out.print("---- full movies --- " + movie);
        Rating newRating = new Rating(rating.getRating(), movie);
        System.out.println("sdfsdfds" +  newRating.getRating());
        ratingRepository.save(newRating);
//        System.out.print(newRating);
        movie.setRatings(newRating);
        movieRepository.save(movie);
    }

    private Movie verifyMovie(int movieId) throws NoSuchElementException {
        System.out.print(movieRepository.findById(movieId).get());
        Movie movie = movieRepository.findById(movieId).get();

        if (movie == null) {
            throw new NoSuchElementException("Movie doesnot exist " + movieId);
        }

        return movie;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();
    }


    @RequestMapping(path="/all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Movie> getAllMovies() {

        return movieRepository.findAll();
    }
}
