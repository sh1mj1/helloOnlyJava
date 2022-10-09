package com.example.helloOnlyJava.core.web;

import com.example.helloOnlyJava.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    //    private final MyLogger myLogger;
    private final ObjectProvider<MyLogger> myLoggerObjectProvider;  // myLogger 을 찾을 수 있는 ObjectProvider 주입

    public void logic(String id) {
//        myLogger.log("service id = " + id);
        // DL (ObjectProvider 로 myLogger 조회 (DL)
        MyLogger myLogger = myLoggerObjectProvider.getObject();
        myLogger.log("service id = " + id);
//        myLogger.log("LogDemoService-MyLogger : " + myLogger);
    }
}
