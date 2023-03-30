package com.ll.gramgram.member.service;

import com.ll.gramgram.member.entity.Member;
import com.ll.gramgram.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    @Transactional
    public Member join(String username, String password) {
        return memberRepository.save(Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .build()
        );
    }
}
