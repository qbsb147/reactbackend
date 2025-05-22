package com.kh.reactbackend.controller;

import com.kh.reactbackend.entity.Movie;
import com.kh.reactbackend.enums.CommonEnums;
import com.kh.reactbackend.service.MemberService;
import jakarta.persistence.PostRemove;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<String> addMember(){
        return null;
    }
}
