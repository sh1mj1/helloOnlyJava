package com.example.helloOnlyJava.service;

import com.example.helloOnlyJava.core.annotation.MainDiscountPolicy;
import com.example.helloOnlyJava.core.discount.DiscountPolicy;
import com.example.helloOnlyJava.entity.Member;
import com.example.helloOnlyJava.entity.Order;
import com.example.helloOnlyJava.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component /* component 어노테이션을 넣어서 스캔 대상이 됨. */
//@RequiredArgsConstructor // final 이 붙은 필드를 파라미터로 갖는 생성자를 자동으로 생성.
public class OrderServiceImp implements OrderService {


    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

//    private final DiscountPolicy rateDiscountPolicy;


    @Autowired /* 자동으로 DI 주입. */
    public OrderServiceImp(MemberRepository memberRepository,
            /*@Qualifier("mainDiscountPolicy")*/ @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

//    @Autowired // rateDiscountPolicy 로
//    public OrderServiceImp(MemberRepository memberRepository,DiscountPolicy rateDiscountPolicy) {
//        this.memberRepository = memberRepository;
//        this.rateDiscountPolicy = rateDiscountPolicy;
//    }

    @Autowired
    public void setDiscountPolicy(@MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }


    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);/*rateDiscountPolicy.discount~*/
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


}

