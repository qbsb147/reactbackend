package com.kh.reactbackend.repository;

import com.kh.reactbackend.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    List<Member> findAll();
    void save(Member member);
    Optional<Member> findByUserNo(Long userNo);
    Optional<Member> findByUserId(String userId);
    void delete(Member member);
}
