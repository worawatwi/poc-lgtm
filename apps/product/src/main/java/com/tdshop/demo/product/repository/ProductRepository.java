package com.tdshop.demo.product.repository;

import com.tdshop.demo.product.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
}