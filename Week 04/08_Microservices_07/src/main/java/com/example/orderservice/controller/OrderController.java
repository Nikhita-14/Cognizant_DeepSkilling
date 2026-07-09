package com.example.orderservice.controller;

import com.example.orderservice.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/user/{userId}")
    public String getOrderWithUserContext(@PathVariable Long userId) {
        Object user = userClient.getUserById(userId);
        return "Order details processed for user: " + user.toString();
    }
}