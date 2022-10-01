package com.example.helloOnlyJava.repository;

import com.example.helloOnlyJava.entity.Member;

// 역할부
public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
