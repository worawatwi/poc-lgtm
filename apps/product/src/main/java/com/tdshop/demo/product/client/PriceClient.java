package com.tdshop.demo.product.client;

import com.tdshop.demo.product.dto.PriceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PriceClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(PriceClient.class);

    @Autowired
    private WebClient client;

    public Mono<PriceDto> getPrice(@PathVariable("id") long productId){
        LOGGER.info("Fetching Price Details With Product Id {}", productId);
        String uri = String.format("/price/%d", productId);
        return this.client.get().uri(uri).accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PriceDto.class);
    }
}
