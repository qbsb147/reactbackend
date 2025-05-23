package com.kh.reactbackend.dto;

import com.kh.reactbackend.entity.Member;
import com.kh.reactbackend.entity.Movie;
import com.kh.reactbackend.entity.MovieGenre;
import com.kh.reactbackend.enums.CommonEnums;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response{

        private Long movie_no;
        private String director;
        private Float movie_grade;
        private String movie_title;
        private String movie_content;
        private String user_id;
        private String user_name;
        private Integer count;
        private String origin_name;
        private String change_name;
        private LocalDateTime create_date;
        private List<CommonEnums.genre> genres;

        public static Response toDto(Movie movie){
            return Response.builder()
                    .movie_no(movie.getMovieNo())
                    .director(movie.getDirector())
                    .movie_grade(movie.getMovieGrade())
                    .movie_title(movie.getMovieTitle())
                    .movie_content(movie.getMovieContent())
                    .user_id(movie.getMember()
                                    .getUserId())
                    .user_name(movie.getMember()
                                    .getUserName())
                    .genres(movie.getMovieGenres()
                                .stream()
                                .map(boardGenre -> boardGenre.getGenre()
                                        .getGenreName())
                                .toList())
                    .origin_name(movie.getOriginName())
                    .change_name(movie.getChangeName())
                    .build();
        }

        public static Response toSimpleDto(Movie movie){
            return Response.builder()
                    .movie_no(movie.getMovieNo())
                    .movie_title(movie.getMovieTitle())
                    .change_name(movie.getChangeName())
                    .count(movie.getCount())
                    .create_date(movie.getCreateDate())
                    .user_id(movie.getMember()
                            .getUserId())
                    .build();
        }

    }

}
