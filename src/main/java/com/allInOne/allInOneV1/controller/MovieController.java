package com.allInOne.allInOneV1.controller;

import com.allInOne.allInOneV1.model.Actor;
import com.allInOne.allInOneV1.model.Movie;
import com.allInOne.allInOneV1.model.Rating;
import com.allInOne.allInOneV1.model.Theatre;
import com.allInOne.allInOneV1.repository.ActorRespository;
import com.allInOne.allInOneV1.repository.MovieRepository;
import com.allInOne.allInOneV1.repository.RatingRepository;
import com.allInOne.allInOneV1.service.SendSMS;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/movie")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ActorRespository actorRespository;

    SendSMS sms = new SendSMS();

    @RequestMapping(path="/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovie(@RequestBody Movie newMovie) {
        movieRepository.save(newMovie);
    }

    @RequestMapping(path="/{movieId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Movie movie(@PathVariable(value = "movieId") int movieId) {
        Movie movie = verifyMovie(movieId);
        return movie;
    }


    @RequestMapping(path="/all", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Movie> getAllMovies() {

        return movieRepository.findAll();
    }

    @RequestMapping(path="/{movieId}/rating", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovieRating(@PathVariable(value = "movieId") int movieId, @RequestBody Rating rating) {
        Movie movie = verifyMovie(movieId);
        Rating newRating = new Rating(rating.getRating(), movie);
        ratingRepository.save(newRating);
        movie.setRatings(newRating);
        movieRepository.save(movie);
//        sms.sendSMS("+13159499748","+13203350324");
    }

    public Movie verifyMovie(int movieId) throws NoSuchElementException {
        Movie movie = movieRepository.findById(movieId).get();

        if (movie == null) {
            throw new NoSuchElementException("Movie does not exist " + movieId);
        }

        return movie;
    }



    @RequestMapping(path="/title", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Movie> getMovieNamesLike(@RequestParam("title") String name) {
        return movieRepository.getMovieNamesLike(name);
    }

    @RequestMapping(path="/top", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Movie> getMovieNamesLike(@RequestParam("count") int count) {
        return movieRepository.getTopMovies(count);
    }

    @RequestMapping(path="/actor", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
     public void addMovieActor(@RequestBody ObjectNode postData) {
            Movie movie = verifyMovie(postData.get("movieId").asInt());
            Actor actor = verifyActor(postData.get("actorId").asInt());
            movie.setActors(actor);
            movieRepository.save(movie);
            actor.setMovies(movie);
            actorRespository.save(actor);
    }

    private Actor verifyActor(int actorId) throws NoSuchElementException {
        Actor actor = actorRespository.findById(actorId).get();
        if (actor == null) {
            throw new NoSuchElementException("Actor does not exist " + actor);
        }
        return actor;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();
    }


    @RequestMapping(path="/{movieId}/theatres", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Theatre> getTheatre(@PathVariable(value = "movieId") int movieId) {
        Movie movie = verifyMovie(movieId);
        List<Theatre> theatreList = movie.getTheatres().stream().collect(Collectors.toList());

        return theatreList;
    }
}
