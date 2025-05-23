package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.MemberDto;
import com.kh.reactbackend.entity.Member;
import com.kh.reactbackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public MemberDto.Response findMember(Long userNo) {
        Member member = memberRepository.findByUserNo(userNo)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다."));
        return MemberDto.Response.toDto(member);
    }

    @Override
    public List<MemberDto.Response> findAllMember() {
        return memberRepository.findAll().stream()
                .map(MemberDto.Response::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createMember(MemberDto.Create createDto) {
        Member member = createDto.toEntity();
        memberRepository.save(member);
    }

    @Override
    @Transactional
    public void updateMember(Long userNo, MemberDto.Update update) {
        Member member = memberRepository.findByUserNo(userNo)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다."));
        member.updateMemberInfo(
                            member.getUserId(),
                            member.getUserPwd(),
                            member.getUserName(),
                            member.getUserNickname(),
                            member.getPhone(),
                            member.getAge(),
                            member.getGender());
    }

    @Override
    @Transactional
    public void deleteMember(Long userNo) {
        Member member  = memberRepository.findByUserNo(userNo)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않느 아이디입니다."));
        memberRepository.delete(member);
    }
}
