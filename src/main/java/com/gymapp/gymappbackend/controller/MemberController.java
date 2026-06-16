package com.gymapp.gymappbackend.controller;

import com.gymapp.gymappbackend.dto.MemberRequest;
import com.gymapp.gymappbackend.entity.Member;
import com.gymapp.gymappbackend.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public Member createMember(@RequestBody MemberRequest request) {
        return memberService.createMember(request);
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @DeleteMapping("/{id}")
    public String  deleteMember(@PathVariable long id){
        memberService.deleteMember(id);
        return "Member deleted successfully";
    }

    @PutMapping("/{id}")
    public String  updateMember(@PathVariable long id,@RequestBody MemberRequest request){
        memberService.updateMember(id,request);
        return "Member updated successfully";
    }
}