package com.example.helloOnlyJava.service;

import com.example.helloOnlyJava.AppConfig;
import com.example.helloOnlyJava.entity.Grade;
import com.example.helloOnlyJava.entity.Member;
import com.example.helloOnlyJava.service.MemberService;
import com.example.helloOnlyJava.service.MemberServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class MemberServiceTest {

//    MemberService memberService = new MemberServiceImp();
//    아래처럼 변경
    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);
        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        // then
        Assertions.assertThat(member).isEqualTo(findMember);

    }

}

