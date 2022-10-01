package com.example.helloOnlyJava.core.beanfind;

import com.example.helloOnlyJava.AppConfig;
import com.example.helloOnlyJava.service.MemberService;
import com.example.helloOnlyJava.service.MemberServiceImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImp.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로 조회")
    void findByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImp.class);
    }

    @Test
    @DisplayName("구현체 타입으로 조회")
    void findByName2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceImp.class);
        assertThat(memberService).isInstanceOf(MemberServiceImp.class);
    }

    @Test
    @DisplayName("빈 이름으로 해당 빈이 없다는 것으로 확인")
    void findByNameX(){
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));
    }


}
