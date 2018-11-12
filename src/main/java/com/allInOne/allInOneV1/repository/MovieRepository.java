package com.allInOne.allInOneV1.repository;

import com.allInOne.allInOneV1.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository <Movie, Integer>, MovieRepositoryCustom {

}