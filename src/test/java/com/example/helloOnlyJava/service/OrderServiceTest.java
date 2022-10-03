package com.example.helloOnlyJava.service;

import com.example.helloOnlyJava.AppConfig;
import com.example.helloOnlyJava.core.discount.FixDiscountPolicy;
import com.example.helloOnlyJava.entity.Grade;
import com.example.helloOnlyJava.entity.Member;
import com.example.helloOnlyJava.entity.Order;
import com.example.helloOnlyJava.repository.MemoryMemberRepository;
import com.example.helloOnlyJava.service.MemberService;
import com.example.helloOnlyJava.service.MemberServiceImp;
import com.example.helloOnlyJava.service.OrderService;
import com.example.helloOnlyJava.service.OrderServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderServiceTest {

//    MemberService memberService = new MemberServiceImp();
//    OrderService orderService = new OrderServiceImp();

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    //    추상(인터페이스) 의존 : DiscountPolicy
//    구체(구현) 클래스 : FixDiscountPolicy


    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }


/*
    @Test
    void createOrder(){
//        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
//        memberRepository.save(new Member(1L, "name", Grade.VIP));
//
//        OrderServiceImp orderService = new OrderServiceImp(memberRepository, new FixDiscountPolicy());
//        Order order = orderService.createOrder(1L, "itemA", 10000);
//
//        assertThat(order.getDiscountPrice()).isEqualTo(1000);

//
//        OrderServiceImp orderService = new OrderServiceImp();
//        Order order = orderService.createOrder(1L, "itemA", 10000);

    }
 */

}

