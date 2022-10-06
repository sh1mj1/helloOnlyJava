package com.example.helloOnlyJava.core.autowired.allbean;

import com.example.helloOnlyJava.AutoAppConfig;
import com.example.helloOnlyJava.core.discount.DiscountPolicy;
import com.example.helloOnlyJava.entity.Grade;
import com.example.helloOnlyJava.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AllBeanTest {

    @Test
    void findAllBean() {
        // AutoAppConfig, DiscountService 스프링 빈 등록
        // AutoAppConfig 에서 컴포넌트 스캔을 통해 @Component 가 붙은 것들 자동 빈 등록됨
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");
        int rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");

        // DiscountService 스프링 빈 잘 등록됐는지 검증
        assertThat(discountService).isInstanceOf(DiscountService.class);

        assertThat(discountPrice).isEqualTo(1000);



        assertThat(rateDiscountPrice).isEqualTo(2000);
    }

    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        // 모든 DiscountPolicy 를 주입
        @Autowired  // 생성자 1개이므로 생략O
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode) {
            // key(스프링 빈 이름) = discountCode 인 할인 정책(DiscountPolicy) 조회
            DiscountPolicy discountPolicy = policyMap.get(discountCode);

            System.out.println("discountCode = " + discountCode);
            System.out.println("discountPolicy = " + discountPolicy);

            // 해당 (멤버, 금액)에 대해 계산한 할인 금액 리턴
            return discountPolicy.discount(member, price);
        }
    }
}
