package com.example.hw28.controller;

import com.example.hw28.dto.OrderDto;
import com.example.hw28.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ludmila Litvinova on 25.01
 */
@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("{id}")
    public OrderDto getOrderById(@PathVariable int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID < 0");
        }
        return orderService.getOrderById(id);
    }

    @GetMapping
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }
}
