package com.example.helloOnlyJava.service;

import com.example.helloOnlyJava.entity.Member;
import com.example.helloOnlyJava.repository.MemberRepository;
import com.example.helloOnlyJava.repository.MemoryMemberRepository;

public class MemberServiceImp implements MemberService{

    //    public final MemberRepository memberRepository = new MemoryMemberRepository();
    // 직접 객체를 생성하는 것 대신 아래처럼 생성자를 통해 주입.
    private final MemberRepository memberRepository;


    // Test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    /**
     * appConfig 객체는 memoryMemberRepository 객체를 생성
     * 그 참조값을 memberServiceImp 을 생성하면서 생성자로 전달한다.
     * 클라이언트인 memberServiceImp 입장에서는 의존관계를 마치 외부에서 주입해주는 것 같다.
     * DI(Dependency Injection) 우리말로 의존관계 주입 또는 의존성 주입이라 한다.
     * @param memberRepository
     */
    public MemberServiceImp(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /*
     * MemberRepository, MemoryMemberRepository 둘다 의존함...
     * 이는 DIP 를 위배한다.(인터페이스, 구현클래스 둘다 의존)
     *  MemberRepository 에만 의존하도록 만들어야한다.
     *
     *  추가로 MemoryMemberRepository 를 사용하지 않는다고 해보자..
     *  그러면 MemberServiceImpl 의 코드가 바뀌게 된다.
     *  OCP 도 위반한다.(확장에는 열려 있으나 변경에는 닫혀 있어야 한다.)
     */

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
