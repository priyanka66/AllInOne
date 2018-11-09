package com.allInOne.allInOneV1.repository;

import com.allInOne.allInOneV1.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
    @Override
    List<Movie> findAll();

    @Override
    Optional<Movie> findById(Integer integer);
}
