package com.example.hw28.service;

import com.example.hw28.dto.OrderDto;
import com.example.hw28.model.Order;
import com.example.hw28.repository.OrderRepository;
import com.example.hw28.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ludmila Litvinova on 25.01
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;


    public OrderDto createOrder(OrderDto orderDto) {
        Order order = objectMapper.convertValue(orderDto, Order.class);
        order = orderRepository.save(order);
        orderDto.setId(order.getId());
        return orderDto;
    }

    public List<OrderDto> getAllOrders() {
        List<OrderDto> listDto = new ArrayList<>();
        Iterable<Order> orders = orderRepository.findAll();
        for (Order order : orders) {
            listDto.add(objectMapper.convertValue(order, OrderDto.class));
        }
        return listDto;
    }

    public OrderDto getOrderById(int id) {
        Order order = orderRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return objectMapper.convertValue(order, OrderDto.class);

    }
}
