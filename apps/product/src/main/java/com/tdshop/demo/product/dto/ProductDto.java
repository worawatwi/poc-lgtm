package com.tdshop.demo.product.dto;

public class ProductDto {

    private long id;

    private String name;

    private PriceDto price;

    public ProductDto(long id, String name, PriceDto price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PriceDto getPrice() {
        return price;
    }

    public void setPrice(PriceDto price) {
        this.price = price;
    }
}
