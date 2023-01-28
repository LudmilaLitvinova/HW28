package com.example.hw28.service;

import com.example.hw28.dto.ProductDto;
import com.example.hw28.model.Product;
import com.example.hw28.repository.OrderRepository;
import com.example.hw28.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * @author Ludmila Litvinova on 25.01
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    @Transactional
    public ProductDto createProduct(ProductDto productDto) {
        Product product = objectMapper.convertValue(productDto, Product.class);
        productRepository.save(product);
        productDto.setId(product.getId());
        return productDto;
    }
}
