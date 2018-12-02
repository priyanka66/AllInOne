package com.allInOne.allInOneV1.controller;

import com.allInOne.allInOneV1.model.Movie;
import com.allInOne.allInOneV1.model.Theatre;
import com.allInOne.allInOneV1.repository.MovieRepository;
import com.allInOne.allInOneV1.repository.TheatreRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/theatre")
public class TheatreController {
        @Autowired
        private TheatreRespository theatreRespository;

        @Autowired
        private MovieRepository movieRepository;

    @RequestMapping(path="/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createtheatre(@RequestBody Theatre newTheatre) {
        theatreRespository.save(newTheatre);
    }

    @RequestMapping(path="/{theatreId}/movie", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addMovie(@PathVariable(value = "theatreId") int theatreId, @RequestBody Movie movieId) throws  NoSuchElementException{
        Movie movie = movieRepository.findById(movieId.getMovieId()).get();
        if (movie == null) {
            throw new NoSuchElementException("Movie does not exist " + movieId);
        }
        Theatre theatre = verifyTheatre(theatreId);
        theatre.setMovies(movie);
        movie.setTheatres(theatre);
        theatreRespository.save(theatre);

    }

    public Theatre verifyTheatre(int theatreId) throws NoSuchElementException {
        Theatre theatre = theatreRespository.findById(theatreId).get();

        if (theatre == null) {
            throw new NoSuchElementException("Theatre does not exist " + theatreId);
        }

        return theatre;
    }

    @RequestMapping(path="/{theatreId}/movies", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Movie> getMovies(@PathVariable(value = "theatreId") int theatreId) {
        Theatre theatre = verifyTheatre(theatreId);
        List<Movie> movieList = theatre.getMovies().stream().collect(Collectors.toList());

        return movieList;
    }


}
