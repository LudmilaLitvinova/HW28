package com.example.hw28;

import com.example.hw28.dto.OrderDto;
import com.example.hw28.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;

/**
 * @author Ludmila Litvinova on 25.01
 */
@SpringBootApplication
public class Hw28Application extends SpringBootServletInitializer {

    @Autowired
    OrderService orderService;

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(Hw28Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Hw28Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void init() {
        OrderDto orderDtoBeef = new OrderDto(null, LocalDate.now(), 125, "beef");
        OrderDto orderDtoCola = new OrderDto(null, LocalDate.now(), 35, "cola");
        OrderDto orderDtoBread = new OrderDto(null, LocalDate.now(), 25, "bread");
        OrderDto orderDtoCoffee = new OrderDto(null, LocalDate.now(), 220, "coffee");
        orderService.createOrder(orderDtoBeef);
        orderService.createOrder(orderDtoCola);
        orderService.createOrder(orderDtoBread);
        orderService.createOrder(orderDtoCoffee);
    }
}