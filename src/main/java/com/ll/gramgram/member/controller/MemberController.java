package com.ll.gramgram.member.controller;

import com.ll.gramgram.member.entity.JoinForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    @GetMapping("/join")
    public String showJoin(JoinForm joinForm) {
        return "usr/member/join";
    }

    @PostMapping("/join")
    public String join(@Valid JoinForm joinForm) {
        return "redirect:/";
    }
}
