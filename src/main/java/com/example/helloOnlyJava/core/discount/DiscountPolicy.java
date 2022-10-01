package com.example.helloOnlyJava.core.discount;

import com.example.helloOnlyJava.entity.Member;

public interface DiscountPolicy {

    /**
     *
     * @param member
     * @param price
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);

}

//
//package hello.core.discount;
//
//        import hello.core.member.Member;
//
//public interface DiscountPolicy {
//    /**
//     * @return 할인 대상 금액
//     */
//    int discount(Member member, int price);
//}
