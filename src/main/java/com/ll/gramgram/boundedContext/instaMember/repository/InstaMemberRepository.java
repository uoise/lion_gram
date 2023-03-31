package com.ll.gramgram.boundedContext.instaMember.repository;

import com.ll.gramgram.boundedContext.instaMember.service.InstaMemberService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstaMemberRepository extends JpaRepository<InstaMemberService, Long> {
}
