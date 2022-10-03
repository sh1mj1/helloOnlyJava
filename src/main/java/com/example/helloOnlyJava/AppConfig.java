package com.example.helloOnlyJava;

import com.example.helloOnlyJava.core.discount.DiscountPolicy;
import com.example.helloOnlyJava.core.discount.FixDiscountPolicy;
import com.example.helloOnlyJava.core.discount.RateDiscountPolicy;
import com.example.helloOnlyJava.repository.MemberRepository;
import com.example.helloOnlyJava.repository.MemoryMemberRepository;
import com.example.helloOnlyJava.service.MemberService;
import com.example.helloOnlyJava.service.MemberServiceImp;
import com.example.helloOnlyJava.service.OrderService;
import com.example.helloOnlyJava.service.OrderServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // appConfig 객체는 memoryMemberRepository 객체를 생성
    // 그 참조값을 memberServiceImp 을 생성하면서 생성자로 전달한다.

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        // 여기서 둘 중 하나만 선택하면 되고 다른 코드는 바꿀 필요가 없어짐!
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }
    @Bean
    public MemberService memberService() {
        return new MemberServiceImp(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImp(
                memberRepository(),
                discountPolicy());
//        return null;
    }

}

