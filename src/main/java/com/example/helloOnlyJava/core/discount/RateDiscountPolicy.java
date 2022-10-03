package com.example.helloOnlyJava.core.discount;

import com.example.helloOnlyJava.entity.Grade;
import com.example.helloOnlyJava.entity.Member;
import org.springframework.stereotype.Component;

@Component
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

