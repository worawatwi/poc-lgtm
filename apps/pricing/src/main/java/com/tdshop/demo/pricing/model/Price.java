package com.tdshop.demo.pricing.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("price")
public class Price {
    @Id
    private long id;
    @Column("product_id")
    private long productId;
    @Column("amount")
    private double priceAmount;
    @Column("discount")
    private double discount;

    public Price() {
    }

    public Price(long id, long productId, double priceAmount, double discount) {
        this.id = id;
        this.productId = productId;
        this.priceAmount = priceAmount;
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getPriceAmount() {
        return priceAmount;
    }

    public void setPriceAmount(double priceAmount) {
        this.priceAmount = priceAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
