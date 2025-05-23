package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.MemberDto;

import java.util.List;

public interface MemberService {

    MemberDto.Response findMember(Long userNo);
    List<MemberDto.Response> findAllMember();
    void createMember(MemberDto.Create createDto);
    void updateMember(Long userNo, MemberDto.Update update);
    void deleteMember(Long userNo);

}
