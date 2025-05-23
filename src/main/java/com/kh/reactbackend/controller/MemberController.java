package com.kh.reactbackend.controller;

import com.kh.reactbackend.dto.MemberDto;
import com.kh.reactbackend.entity.Member;
import com.kh.reactbackend.entity.Movie;
import com.kh.reactbackend.enums.CommonEnums;
import com.kh.reactbackend.service.MemberService;
import jakarta.persistence.PostRemove;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{userNo}")
    public ResponseEntity<MemberDto.Response> getMember(@PathVariable Long userNo){
        return ResponseEntity.ok(memberService.findMember(userNo));
    }

    @GetMapping
    public ResponseEntity<List<MemberDto.Response>> getAllMembers(){
        return ResponseEntity.ok(memberService.findAllMember());
    }

    @PostMapping
    public ResponseEntity<Void> addMember(@RequestBody MemberDto.Create createDto){
        memberService.createMember(createDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userNo}")
    public ResponseEntity<Void> updateMember(
            @PathVariable Long userNo,
            @RequestBody MemberDto.Update updateDto){
        memberService.updateMember(userNo, updateDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userNo}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long userNo){
        memberService.deleteMember(userNo);
        return ResponseEntity.ok().build();
    }
}
