package com.kh.reactbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_no")
    private Long movieNo;

    @Column(name = "director", nullable = false, length = 50)
    private String director;

    @Column(name = "movie_grade", nullable = false, precision = 2, scale = 1)
    private Float movieGrade;

    @Column(name="movie_title", nullable = false, length = 50)
    private String movieTitle;

    @Column(name="movie_content", columnDefinition = "TEXT")
    private String movieContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="movie_writer")
    private Member member;

    @Column(name = "origin_name", nullable = false, length = 30)
    private String originName;

    @Column(name ="change_name", nullable = false, length = 50)
    private String changeName;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<MovieGenre> movieGenres = new ArrayList<>();

}
