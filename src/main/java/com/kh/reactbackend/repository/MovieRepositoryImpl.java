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
        String query = "select m from Member m where m.status = :status";
        List<Movie> movies = entityManager.createQuery(query, Movie.class)
                .setParameter("status", status)
                .setFirstResult((int)pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();
        String countQuery = "select m from Member m where m.status = :status";
        Long totalCount = entityManager.createQuery(countQuery, Long.class)
                .setParameter("status", status)
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
