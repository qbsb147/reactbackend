package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.MemberDto;
import com.kh.reactbackend.entity.Member;
import com.kh.reactbackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService{

    private final String UPLOAD_PATH = "C:\\reactbackend\\src\\main\\resources\\uploads";
    private final MemberRepository memberRepository;

    @Override
    public MemberDto.Response findByUserId(String userId) {
        Member member = memberRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다."));
        return MemberDto.Response.toDto(member);
    }

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

    @Transactional
    @Override
    public void createMember(MemberDto.Create createMember) throws IOException {

        String changeName = null;
        String originName = null;
        System.out.println("member.getChangeName() = " + createMember.getFile().getOriginalFilename());
        if(createMember.getFile() != null && !createMember.getFile().isEmpty()){
            originName = createMember.getFile().getOriginalFilename();
            changeName = UUID.randomUUID() + "_" + originName;
            System.out.println("changeName = " + changeName);
            File uploadDir = new File(UPLOAD_PATH);
            if(!uploadDir.exists()){
                uploadDir.mkdirs();
            }

            createMember.getFile()
                    .transferTo(new File(UPLOAD_PATH + changeName));
        }

        Member member = createMember.toEntity();
        member.changeFile(originName, changeName);
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
                            member.getOriginName(),
                            member.getChangeName(),
                            member.getPhone(),
                            member.getAge(),
                            member.getGender());
    }

    @Override
    @Transactional
    public void deleteMember(Long userNo) {
        Member member  = memberRepository.findByUserNo(userNo)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다."));
        memberRepository.delete(member);
    }
}
