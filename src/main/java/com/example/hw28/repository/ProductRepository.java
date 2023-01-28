package com.example.hw28.repository;

import com.example.hw28.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ludmila Litvinova on 25.01
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
