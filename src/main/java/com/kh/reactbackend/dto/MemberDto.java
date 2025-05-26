package com.kh.reactbackend.dto;

import com.kh.reactbackend.entity.Member;
import com.kh.reactbackend.entity.Movie;
import com.kh.reactbackend.enums.CommonEnums;
import jakarta.persistence.Column;
import lombok.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MemberDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response{
        private Long user_no;
        private String user_id;
        private String user_pwd;
        private String user_name;
        private String user_nickname;
        private String phone;
        private Integer age;
        private CommonEnums.gender gender;
        private CommonEnums.status status;
        private LocalDateTime create_date;
        private Timestamp update_at;

        public static Response toDto(Member member){
            return Response.builder()
                    .user_no(member.getUserNo())
                    .user_id(member.getUserId())
                    .user_pwd(member.getUserPwd())
                    .user_name(member.getUserName())
                    .user_nickname(member.getUserNickname())
                    .phone(member.getPhone())
                    .age(member.getAge())
                    .gender(member.getGender())
                    .status(member.getStatus())
                    .create_date(member.getCreateDate())
                    .update_at(member.getUpdateAt())
                    .build();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Create{

        private String image;
        private String user_id;
        private String user_pwd;
        private String user_name;
        private String user_nickname;
        private String phone;
        private Integer age;
        private CommonEnums.gender gender;
        private CommonEnums.status status;

        public Member toEntity(){
            return Member.builder()
                    .userId(user_id)
                    .userPwd(user_pwd)
                    .userName(user_name)
                    .userNickname(user_nickname)
                    .phone(phone)
                    .age(age)
                    .gender(gender)
                    .status(status)
                    .build();
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Update{

        private String image;
        private String user_id;
        private String user_pwd;
        private String user_name;
        private String user_nickname;
        private String phone;
        private Integer age;
        private CommonEnums.gender gender;
        private CommonEnums.status status;

        public Member toEntity(){
            return Member.builder()
                    .userId(user_id)
                    .userPwd(user_pwd)
                    .userName(user_name)
                    .userNickname(user_nickname)
                    .phone(phone)
                    .age(age)
                    .gender(gender)
                    .build();
        }
    }
}
