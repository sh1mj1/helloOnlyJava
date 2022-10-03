package com.example.helloOnlyJava.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

/*
getter, setter toString() 자동 생성
This is Test Class!
 */
@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdgfe");

        System.out.println("helloLombok = " + helloLombok);
    }


}
