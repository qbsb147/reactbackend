package com.kh.reactbackend.controller;

import com.kh.reactbackend.dto.MovieDto;
import com.kh.reactbackend.dto.PageResponse;
import com.kh.reactbackend.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<PageResponse<MovieDto.Response>> getPagingMovies(
            @PageableDefault(size = 5, sort = "movieNo", direction = Sort.Direction.DESC) Pageable pageable){
        return ResponseEntity.ok(new PageResponse<>(movieService.getMovieList(pageable)));
    }

    @DeleteMapping("/{movieNo}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("movieNo") Long movieNo){
        movieService.deleteMovie(movieNo);
        return ResponseEntity.ok().build();
    }
}
