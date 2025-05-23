package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.MemberDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MemberService {

    MemberDto.Response findMember(Long userNo);
    MemberDto.Response findByUserId(String userId);
    List<MemberDto.Response> findAllMember();
    void createMember(MemberDto.Create createDto);
    void updateMember(Long userNo, MemberDto.Update update);
    void deleteMember(Long userNo);

}
