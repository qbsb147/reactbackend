package com.kh.reactbackend.controller;

import com.kh.reactbackend.dto.MemberDto;
import com.kh.reactbackend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{userNo}")
    public ResponseEntity<MemberDto.Response> getMember(@PathVariable Long userNo){
        MemberDto.Response member = memberService.findMember(userNo);
        System.out.println("member = " + member.getChange_name());
        return ResponseEntity.ok(member);
    }

    @GetMapping(params = "userId")
    public ResponseEntity<MemberDto.Response> findByUserId(@RequestParam String userId){
        MemberDto.Response member = memberService.findByUserId(userId);
        return ResponseEntity.ok(member);
    }

    @GetMapping
    public ResponseEntity<List<MemberDto.Response>> getAllMembers(){
        return ResponseEntity.ok(memberService.findAllMember());
    }

    @PostMapping
    public ResponseEntity<Void> addMember(@ModelAttribute MemberDto.Create createDto) throws IOException {
        memberService.createMember(createDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userNo}")
    public ResponseEntity<Void> updateMember(
            @PathVariable Long userNo,
            @ModelAttribute MemberDto.Update updateDto) throws IOException {
        memberService.updateMember(userNo, updateDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userNo}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long userNo){
        memberService.deleteMember(userNo);
        return ResponseEntity.ok().build();
    }
}
