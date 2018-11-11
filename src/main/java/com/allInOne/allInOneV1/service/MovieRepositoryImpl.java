package com.allInOne.allInOneV1.service;

import com.allInOne.allInOneV1.model.Movie;
import com.allInOne.allInOneV1.repository.MovieRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MovieRepositoryImpl implements MovieRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Movie> getMovieNamesLike(String title) {
        Query query = entityManager.createNativeQuery("SELECT em.* FROM Movie as em " +
                "WHERE em.title LIKE ?", Movie.class);
        query.setParameter(1, title + "%");
        return query.getResultList();
    }


    @Override
    public List<Movie> getTopMovies(int count) {
        Query query = entityManager.createQuery("SELECT m FROM Movie m JOIN Rating r ON " +
                "m.movieId = r.movie.movieId ORDER BY r.rating DESC");
        return query.setMaxResults(2).getResultList();
    }
}


