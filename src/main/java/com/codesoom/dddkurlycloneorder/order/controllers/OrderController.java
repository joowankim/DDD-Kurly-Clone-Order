package com.codesoom.dddkurlycloneorder.order.controllers;

import com.codesoom.dddkurlycloneorder.order.dto.OrderSheetData;
import com.codesoom.dddkurlycloneorder.order.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/orders")
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody OrderSheetData orderSheetData) {
        orderService.orderWith(orderSheetData);
    }
}
