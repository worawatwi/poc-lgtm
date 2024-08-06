package com.tdshop.demo.product.controller;

import com.tdshop.demo.product.client.PriceClient;
import com.tdshop.demo.product.dto.ProductDto;
import com.tdshop.demo.product.repository.ProductRepository;
import io.micrometer.core.instrument.Metrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.tdshop.demo.product.configuration.Constant.API_COUNTER_NAME;
import static com.tdshop.demo.product.configuration.Constant.FUNCTION;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final PriceClient priceClient;

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(PriceClient priceClient, ProductRepository productRepository) {
        this.priceClient = priceClient;
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/{id}")
    public Mono<ProductDto> getProductDetails(@PathVariable("id") long productId){
        LOGGER.info("Getting Product and Price Details With Product Id {}", productId);
        return productRepository.findById(productId)
                .flatMap(product -> priceClient.getPrice(productId)
                        .map(price -> new ProductDto(productId, product.getName(), price))
                )
                .doOnNext(e -> Metrics.counter(API_COUNTER_NAME, FUNCTION, "get_product").increment());
    }
}
