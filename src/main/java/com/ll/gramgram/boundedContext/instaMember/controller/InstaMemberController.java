package com.ll.gramgram.boundedContext.instaMember.controller;

import com.ll.gramgram.base.Rq.Rq;
import com.ll.gramgram.base.rsData.RsData;
import com.ll.gramgram.boundedContext.instaMember.entity.InstaMember;
import com.ll.gramgram.boundedContext.instaMember.service.InstaMemberService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/instaMember")
@RequiredArgsConstructor
public class InstaMemberController {

    private final Rq rq;
    private final InstaMemberService instaMemberService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/connect")
    public String showConnect() {
        return "usr/instaMember/connect";
    }

    public record ConnectForm(@NotBlank @Size(min = 4, max = 30) String username,
                              @NotBlank @Size(min = 1, max = 1) String gender) {
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/connect")
    public String connect(@Valid ConnectForm connectForm) {
        RsData<InstaMember> rsData = instaMemberService.connect(rq.getMember(), connectForm.username, connectForm.gender);
        return rq.redirectWithMsg("/pop", "인스타그램 계정이 연결되었습니다.");
    }
}
