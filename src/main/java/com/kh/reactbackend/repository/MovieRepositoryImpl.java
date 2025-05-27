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
        String query = "select m from Movie m";
        List<Movie> movies = entityManager.createQuery(query, Movie.class)
                .setFirstResult((int)pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();
        String countQuery = "select count(m) from Movie m";
        Long totalCount = entityManager.createQuery(countQuery, Long.class)
                .getSingleResult();
        return new PageImpl<>(movies, pageable, totalCount);
    }

    @Override
    public Optional<Movie> findByMovieNo(Long movieNo) {
        return Optional.empty();
    }

    @Override
    public String delete(Movie movie) {
        return "";
    }
}
