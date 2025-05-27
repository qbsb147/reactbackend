package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.MovieDto;
import com.kh.reactbackend.entity.Movie;
import com.kh.reactbackend.enums.CommonEnums;
import com.kh.reactbackend.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Page<MovieDto.Response> getMovieList(Pageable pageable) {
        Page<Movie> page = movieRepository.findByStatus(CommonEnums.status.Y, pageable);
        System.out.println("page = " + page.getTotalPages());
        return page.map(MovieDto.Response::toSimpleDto);
    }

    @Transactional
    @Override
    public void deleteMovie(Long movieNo) {
        Movie movie = movieRepository.findByMovieNo(movieNo)
                .orElseThrow(()-> new IllegalArgumentException("해당 유저를 찾을 수가 없습니다."));
        movieRepository.delete(movie);
    }
}
