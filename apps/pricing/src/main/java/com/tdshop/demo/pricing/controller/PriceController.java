package com.tdshop.demo.pricing.controller;

import com.tdshop.demo.pricing.exception.PriceNotFoundException;
import com.tdshop.demo.pricing.model.Price;
import com.tdshop.demo.pricing.repository.PriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/price")
public class PriceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PriceController.class);

    @Autowired
    private PriceRepository priceRepository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseEntity<Price>> create(@RequestBody Price price) {
        return priceRepository.save(price)
                .map(e -> ResponseEntity.status(HttpStatus.CREATED).body(e));
    }

    @GetMapping(path = "/{id}")
    public Mono<Price> getPrice(@PathVariable("id") long productId) {
        LOGGER.info("Getting Price details for Product Id {}", productId);
        return priceRepository.findByProductId(productId).switchIfEmpty(Mono.error(new PriceNotFoundException("Price not found")));
    }
}
