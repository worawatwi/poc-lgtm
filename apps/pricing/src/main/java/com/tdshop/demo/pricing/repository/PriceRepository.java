package com.tdshop.demo.pricing.repository;

import com.tdshop.demo.pricing.model.Price;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PriceRepository extends ReactiveCrudRepository<Price, Long> {
    Mono<Price> findByProductId(Long productId);
}