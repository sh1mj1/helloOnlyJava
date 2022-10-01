package com.example.helloOnlyJava.service;

import com.example.helloOnlyJava.core.discount.DiscountPolicy;
import com.example.helloOnlyJava.core.discount.FixDiscountPolicy;
import com.example.helloOnlyJava.core.discount.RateDiscountPolicy;
import com.example.helloOnlyJava.entity.Member;
import com.example.helloOnlyJava.entity.Order;
import com.example.helloOnlyJava.repository.MemberRepository;
import com.example.helloOnlyJava.repository.MemoryMemberRepository;

public class OrderServiceImp implements OrderService{


//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 직접 객체를 생성하는 것 대신 아래처럼 생성자를 통해 주입.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;


    public OrderServiceImp(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

