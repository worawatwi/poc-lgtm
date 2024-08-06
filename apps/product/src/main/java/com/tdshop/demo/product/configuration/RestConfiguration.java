package com.tdshop.demo.product.configuration;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import static com.tdshop.demo.product.configuration.Constant.API_COUNTER_NAME;
import static com.tdshop.demo.product.configuration.Constant.FUNCTION;

@Configuration
public class RestConfiguration {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(baseUrl).build();
    }

    @Bean
    public Counter eventCounter(MeterRegistry registry) {
        return Counter.builder(API_COUNTER_NAME).tags(FUNCTION, "").register(registry);
    }

    @Value("${priceClient.baseUrl}")
    private String baseUrl;
}