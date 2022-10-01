package com.example.helloOnlyJava.service;

import com.example.helloOnlyJava.AppConfig;
import com.example.helloOnlyJava.core.discount.DiscountPolicy;
import com.example.helloOnlyJava.entity.Grade;
import com.example.helloOnlyJava.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateDiscountPolicyTest {

//    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    DiscountPolicy discountPolicy;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        discountPolicy = appConfig.discountPolicy();
    }

    @Test
    @DisplayName("================ IF VIP, disocount 10% =================")
    void isVip() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        Assertions.assertThat(discount).isEqualTo(10000 * 10 / 100);
    }

    @Test
    @DisplayName("================ If not VIP, No discount ================")
    void isNotVip(){
        // given
        Member member = new Member(1L, "memberBasic", Grade.BASIC);
        // when
        int discount = discountPolicy.discount(member, 10000);
        // then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}