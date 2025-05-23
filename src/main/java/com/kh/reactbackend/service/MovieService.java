package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.MovieDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {

    Page<MovieDto.Response> getMovieList(Pageable pageable);

    void deleteMovie(Long movieNo);

}
