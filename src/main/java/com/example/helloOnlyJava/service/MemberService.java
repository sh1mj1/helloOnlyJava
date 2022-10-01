package com.example.helloOnlyJava.service;

import com.example.helloOnlyJava.entity.Member;

// 역할부
public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
