package com.dennis.onlineshopinterview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.UUID;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @NonNull
    @Column(name = "ProductName")
    private String productName;
    @NonNull
    @Column(name = "ProductImageUrl")
    private String productImageUrl;
    @NonNull
    @Column(name = "Weight")
    private double weight;
    @NonNull
    @Column(name = "Price")
    private double price;
    @NonNull
    @Column(name = "PromotionalPrice")
    private double promotionalPrice;

    //Many to One relationship
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "CategoryId")
    Category category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
