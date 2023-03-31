package com.ll.gramgram.boundedContext.home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/adm")
public class AdmHomeController {

    @GetMapping("")
    @ResponseBody
    @PreAuthorize("hasAuthority('admin')")
    public String admHome() {
        return "hi admin";
    }
}
