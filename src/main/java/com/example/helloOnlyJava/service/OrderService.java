package com.example.helloOnlyJava.service;

import com.example.helloOnlyJava.entity.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
