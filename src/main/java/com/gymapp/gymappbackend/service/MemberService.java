package com.gymapp.gymappbackend.service;

import com.gymapp.gymappbackend.dto.MemberRequest;
import com.gymapp.gymappbackend.entity.Member;
import com.gymapp.gymappbackend.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(MemberRequest request) {

        Member member = new Member();
        member.setName(request.getName());
        member.setEmail(request.getEmail());
        member.setPhone(request.getPhone());

        return memberRepository.save(member);
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
    }

    public void deleteMember(Long id) {

        if (!memberRepository.existsById(id)) {
            throw new RuntimeException("Member not found with id: " + id);
        }

        memberRepository.deleteById(id);
    }
    public void updateMember(Long id , MemberRequest request) {

        Member existMember = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));


        existMember.setEmail(request.getEmail());
        existMember.setName(request.getName());
        existMember.setPhone(request.getPhone());
         memberRepository.save(existMember);
    }

}
