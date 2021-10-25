package com.codesoom.dddkurlycloneorder.order.controllers;

import com.codesoom.dddkurlycloneorder.order.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/orders")
@RestController
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(){
        return "hello";
    }
}
