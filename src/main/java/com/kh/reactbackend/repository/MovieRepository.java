package com.kh.reactbackend.repository;

import com.kh.reactbackend.entity.Movie;
import com.kh.reactbackend.enums.CommonEnums;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MovieRepository {
    Page<Movie> findByStatus(CommonEnums.status status, Pageable pageable);
    Optional<Movie> findByMovieNo(Long movieNo);
    String delete(Movie movie);
}
