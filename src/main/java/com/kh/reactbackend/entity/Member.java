package com.kh.reactbackend.entity;


import com.kh.reactbackend.enums.CommonEnums;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.kh.reactbackend.enums.CommonEnums.status.Y;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Long userNo;

    @Column(name = "origin_name", length = 100)
    private String originName;

    @Column(name = "change_name", length = 100)
    private String changeName;

    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;

    @Column(name = "user_pwd", nullable = false, length = 100)
    private String userPwd;

    @Column(name = "user_name", nullable = false, length = 30)
    private String userName;

    @Column(name = "user_nickname", nullable = false, length = 50)
    private String userNickname;

    @Column(name = "phone", nullable = false, length = 13)
    private String phone;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "gender", nullable = false)
    private CommonEnums.gender gender;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CommonEnums.status status;

    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = "update_at")
    private Timestamp updateAt;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Movie> movies = new ArrayList<>();

    @PrePersist
    protected void onCreate(){
        this.createDate = LocalDateTime.now();
        this.status = Y;
    }

    public void updateMemberInfo(String userId,
                                 String userPwd,
                                 String userName,
                                 String userNickname,
                                 String originName,
                                 String changeName,
                                 String phone,
                                 Integer age,
                                 CommonEnums.gender gender){
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userNickname = userNickname;
        this.originName = originName;
        this.changeName = changeName;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
    }

    public void changeFile(String originName, String changeName) {
        this.originName = originName;
        this.changeName = changeName;
    }
}
