package com.kh.reactbackend.entity;

import com.kh.reactbackend.enums.CommonEnums;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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

    @Column(name = "movie_grade", nullable = false)
    private Float movieGrade;

    @Column(name="movie_title", nullable = false, length = 50)
    private String movieTitle;

    @Column(name="movie_content", columnDefinition = "TEXT")
    private String movieContent;

    private Integer count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="movie_writer")
    private Member member;

    @Column(name = "origin_name",length = 30)
    private String originName;

    @Column(name ="change_name", length = 50)
    private String changeName;

    @Column(name="create_date", nullable = false)
    private LocalDateTime createDate;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CommonEnums.status status;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<MovieGenre> movieGenres = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        this.createDate = LocalDateTime.now();
        this.count=0;
        if(this.status == null){
            this.status = CommonEnums.status.Y;
        }
    }

    public void changeStatus(CommonEnums.status status){
        this.status = status;
    }
}
