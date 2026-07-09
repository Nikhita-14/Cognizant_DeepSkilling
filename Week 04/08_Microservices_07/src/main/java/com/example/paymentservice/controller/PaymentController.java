package com.example.paymentservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/process")
    @CircuitBreaker(name = "paymentServiceCB", fallbackMethod = "fallbackPayment")
    public String processPayment() {
        // Simulating invocation of a slow third-party API gateway
        return restTemplate.getForObject("https://slow-third-party-vendor.com/api/pay", String.class);
    }

    public String fallbackPayment(Throwable throwable) {
        logger.error("Circuit breaker tripped! Fallback triggered. Reason: {}", throwable.getMessage());
        return "Payment service is currently operating in degraded fallback mode. Please try again later.";
    }
}