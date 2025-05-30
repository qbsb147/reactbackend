package com.kh.reactbackend.repository;


import com.kh.reactbackend.entity.Movie;
import com.kh.reactbackend.enums.CommonEnums;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Movie> findByStatus(CommonEnums.status status, Pageable pageable) {
        String query = "select m from Movie m JOIN FETCH m.member join fetch m.movieGenres g join fetch g.genre where m.status=:status";
//        String query = "select m from Movie m JOIN m.member join m.movieGenres g join g.genre where m.status=:status";
//        String query = "select m from Movie m where m.status=:status";
        List<Movie> movies = entityManager.createQuery(query, Movie.class)
                .setParameter("status", status)
                .setFirstResult((int)pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();
        String countQuery = "select count(m) from Movie m where m.status=:status";
        Long totalCount = entityManager.createQuery(countQuery, Long.class)
                .setParameter("status", status)
                .getSingleResult();
        return new PageImpl<>(movies, pageable, totalCount);
    }

    @Override
    public Optional<Movie> findByMovieNo(Long movieNo) {
        String query = "select m from Movie m where m.movieNo=:movieNo and m.status=:status";
        Movie movie = entityManager.createQuery(query,Movie.class)
                .setParameter("movieNo", movieNo)
                .setParameter("status", CommonEnums.status.Y)
                .getSingleResult();
        System.out.println("movie = " + movie);
        return Optional.ofNullable(movie);
    }

    @Override
    public void save(Movie movie) {
        entityManager.persist(movie);
    }
}
