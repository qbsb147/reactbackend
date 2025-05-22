package com.kh.reactbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "movie_genre")
public class MovieGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_genre_no")
    private Long movieGenreNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_no")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_no")
    private Genre genre;

    public void changeGenre(Genre genre){
        this.genre = genre;
        movie.getMovieGenres().add(this);
    }
}
