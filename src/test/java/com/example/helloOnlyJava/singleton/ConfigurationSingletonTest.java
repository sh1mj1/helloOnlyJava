package com.example.helloOnlyJava.singleton;

import com.example.helloOnlyJava.AppConfig;
import com.example.helloOnlyJava.repository.MemberRepository;
import com.example.helloOnlyJava.service.MemberServiceImp;
import com.example.helloOnlyJava.service.OrderServiceImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConfigurationSingletonTest {

    @Test
    @DisplayName("싱글톤이 깨지지 않았는지 테스트")
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImp memberService = ac.getBean("memberService", MemberServiceImp.class);
        OrderServiceImp orderService = ac.getBean("orderService", OrderServiceImp.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        // 모두 같은 인스턴스를 참조하고 있다.. (싱글톤 패턴이 깨지지 않았다!)
        System.out.println("memberService -> memberRepository1 = "  + memberRepository1);
        System.out.println("orderService -> memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        // 모두 같은 인스턴스를 참조
        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);


    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // AppConfig 도 스프링 빈으로 등록됨.
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
        // bean = class com.example.helloOnlyJava.AppConfig$$EnhancerBySpringCGLIB$$adafc678
    }


}
