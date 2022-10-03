package com.example.helloOnlyJava.service;

import com.example.helloOnlyJava.core.discount.DiscountPolicy;
import com.example.helloOnlyJava.core.discount.FixDiscountPolicy;
import com.example.helloOnlyJava.core.discount.RateDiscountPolicy;
import com.example.helloOnlyJava.entity.Member;
import com.example.helloOnlyJava.entity.Order;
import com.example.helloOnlyJava.repository.MemberRepository;
import com.example.helloOnlyJava.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component /* component 어노테이션을 넣어서 스캔 대상이 됨. */
public class OrderServiceImp implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;


    @Autowired /* 자동으로 DI 주입. */
    public OrderServiceImp(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

