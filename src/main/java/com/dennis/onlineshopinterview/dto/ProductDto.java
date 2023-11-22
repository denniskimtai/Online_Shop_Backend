package com.dennis.onlineshopinterview.dto;

import jakarta.persistence.Column;
import org.springframework.lang.NonNull;

public class ProductDto {
    private Integer id;
    @NonNull
    private String productName;
    @NonNull
    private String productImageUrl;
    @NonNull
    private double weight;
    @NonNull
    private double price;
    @NonNull
    private double promotionalPrice;
    @NonNull
    private Integer categoryId;

    public ProductDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NonNull
    public String getProductName() {
        return productName;
    }

    public void setProductName(@NonNull String productName) {
        this.productName = productName;
    }

    @NonNull
    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(@NonNull String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPromotionalPrice() {
        return promotionalPrice;
    }

    public void setPromotionalPrice(double promotionalPrice) {
        this.promotionalPrice = promotionalPrice;
    }

    @NonNull
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(@NonNull Integer categoryId) {
        this.categoryId = categoryId;
    }
}
