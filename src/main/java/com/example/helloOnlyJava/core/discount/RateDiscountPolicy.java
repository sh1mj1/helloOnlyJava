package com.example.helloOnlyJava.core.discount;

import com.example.helloOnlyJava.core.annotation.MainDiscountPolicy;
import com.example.helloOnlyJava.entity.Grade;
import com.example.helloOnlyJava.entity.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary // 우선권 부여
//@Qualifier("mainDiscountPolicy")  // mainDiscountPolicy 는 컴파일 시 타입 체크 안됨.
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {

            return 0;
        }
    }
}

