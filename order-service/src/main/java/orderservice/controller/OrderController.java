package com.techie.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final RestTemplate restTemplate;

    @Autowired
    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{id}")
    public String createOrder(@PathVariable Long id) {

        String product = restTemplate.getForObject(
                "http://PRODUCT-SERVICE/products/" + id,
                String.class
        );

        return "Order created successfully for product -> " + product;
    }
}