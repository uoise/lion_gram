package com.ll.gramgram.base.Rq;

import com.ll.gramgram.boundedContext.member.entity.Member;
import com.ll.gramgram.boundedContext.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


@Component
@RequestScope
public class Rq {
    private final MemberService memberService;
    private final HttpServletRequest req;
    private final HttpServletResponse rsp;
    private final HttpSession session;
    private final User user;
    private Member member = null;

    public Rq(MemberService memberService, HttpServletRequest req, HttpServletResponse rsp, HttpSession session) {
        this.memberService = memberService;
        this.req = req;
        this.rsp = rsp;
        this.session = session;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof User principalUser) {
            this.user = principalUser;
        } else {
            this.user = null;
        }
    }

    public boolean isLogin() {
        return user != null;
    }

    public boolean isLogout() {
        return !isLogin();
    }

    public Member getMember() {
        if (isLogout()) return null;
        if (member == null) {
            member = memberService.findByUsername(user.getUsername()).orElseThrow(
                    () -> new UsernameNotFoundException("%s not found".formatted(user.getUsername())));
        }
        return member;
    }
}
