package com.example.helloOnlyJava.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request")
public class MyLogger {
    private String uuid;        // HTTP 요청 구분 id
    private String requestURL;  // 실제 요청한 URL

    // DI (requestURL)
    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    // 로그 출력
    public void log(String msg){
        System.out.println("[" + uuid + "]" + "[" + requestURL + "]" + msg);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString(); // 전세계 유일 id 생성해서 저장
        System.out.println("[" + uuid + "] request scope bean create:" + this );
    }

    @PreDestroy
    public void clos() {
        System.out.println("[" + uuid + "] request scope bean close: " + this);
    }
}

