package com.example.helloOnlyJava.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SingletonJsrProvider {

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init" + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy" + this);
        }
    }


    @Scope("singleton")
    static class ClientBean {

        @Autowired
        private Provider<PrototypeBean> prototypeBeanProvider;
        public int logic() {
            PrototypeBean prototypeBean = prototypeBeanProvider.get();
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }

    }

    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonJsrProvider.ClientBean.class, SingletonJsrProvider.PrototypeBean.class);

        SingletonJsrProvider.ClientBean clientBean1 = ac.getBean(SingletonJsrProvider.ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        SingletonJsrProvider.ClientBean clientBean2 = ac.getBean(SingletonJsrProvider.ClientBean.class);
        int count2 = clientBean1.logic();
        assertThat(count2).isEqualTo(1);
    }


}
