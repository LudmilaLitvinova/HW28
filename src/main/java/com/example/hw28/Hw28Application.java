package com.example.hw28;

import com.example.hw28.dto.OrderDto;
import com.example.hw28.dto.ProductDto;
import com.example.hw28.service.OrderService;
import com.example.hw28.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ludmila Litvinova on 25.01
 */
@SpringBootApplication
public class Hw28Application extends SpringBootServletInitializer {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(Hw28Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Hw28Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
//    @Transactional
    public void init() {
        ProductDto beef = new ProductDto(null, "BEEF", 178);
        ProductDto cola = new ProductDto(null, "COCA-COLA", 50);
        ProductDto bread = new ProductDto(null, "BREAD", 24);
        ProductDto coffee= new ProductDto(null, "COFFEE", 560);
        beef = productService.createProduct(beef);
        cola = productService.createProduct(cola);
        bread = productService.createProduct(bread);
        coffee = productService.createProduct(coffee);

        List<ProductDto> drinks = new ArrayList<>();
        drinks.add(cola);
        drinks.add(coffee);
        List<ProductDto>  sandwich = new ArrayList<>();
        sandwich.add(beef);
        sandwich.add(bread);

        OrderDto orderDtoSandwich = new OrderDto(null, LocalDate.now(), 202, sandwich);
        OrderDto orderDtoDrinks = new OrderDto(null, LocalDate.now(), 610, drinks);
        orderService.createOrder(orderDtoDrinks);
        orderService.createOrder(orderDtoSandwich);

    }
}