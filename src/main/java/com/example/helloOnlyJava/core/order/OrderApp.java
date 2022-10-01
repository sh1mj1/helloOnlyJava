package com.example.helloOnlyJava.core.order;

import com.example.helloOnlyJava.AppConfig;
import com.example.helloOnlyJava.entity.Grade;
import com.example.helloOnlyJava.entity.Member;
import com.example.helloOnlyJava.entity.Order;
import com.example.helloOnlyJava.service.MemberService;
import com.example.helloOnlyJava.service.MemberServiceImp;
import com.example.helloOnlyJava.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appconfig = new AppConfig();
//        MemberService memberService = appconfig.memberService();
//        OrderService orderService = appconfig.orderService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order.toString());

    }
}


