package com.example.helloOnlyJava.core.beanlifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    /*
    @Configuration
    static class LifeCycleConfigInter {
        @Bean
        public NetworkClientUsingInterface networkClient() {
            NetworkClientUsingInterface networkClient = new NetworkClientUsingInterface();
            networkClient.setUrl("http://hello-spring.dec");
            return networkClient;
        }
    }

    @Test
    public void lifeCycleTestUsingInterface() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfigInter.class);
        NetworkClientUsingInterface client = ac.getBean(NetworkClientUsingInterface.class);
        ac.close(); //스프링 컨테이너를 종료, ConfigurableApplicationContext 필요
    }

     */

    // 수동 빈 등록 방식
    /*
    @Configuration
    static class LifeCycleConfigConfig {
        @Bean
        public NetworkClientUsingConfig networkClientUsingConfig() {
            NetworkClientUsingConfig networkClientUsingConfig = new NetworkClientUsingConfig();
            networkClientUsingConfig.setUrl("http://hello-spring.dec");
            return networkClientUsingConfig;
        }
    }
    */
    // 자동 빈 등록 방식
    @Configuration
    @ComponentScan
    static class LifeCycleConfigConfig{

    }

    @Test
    public void lifeCycleTestUsingConfig() {
        System.out.println("LifeCycleTestUsingConfig - Auto");
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfigConfig.class);
//        NetworkClientUsingConfig client = ac.getBean(NetworkClientUsingConfig.class);
//        ac.close(); //스프링 컨테이너를 종료, ConfigurableApplicationContext 필요

    }



}
