package com.ll.gramgram.boundedContext.instaMember.service;

import com.ll.gramgram.boundedContext.instaMember.repository.InstaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InstaMemberService {

    private final InstaMemberRepository instaMemberRepository;
}
