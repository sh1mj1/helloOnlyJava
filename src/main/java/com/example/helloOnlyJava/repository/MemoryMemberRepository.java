package com.example.helloOnlyJava.repository;

import com.example.helloOnlyJava.entity.Member;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// 구현부
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new ConcurrentHashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

}
