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
    @Column(name = "Id", nullable = false)
    private UUID id;
    @Column(name = "ProductName", nullable = false)
    private String productName;
    @Column(name = "ProductImageUrl", nullable = false)
    private String productImageUrl;
    @Column(name = "Weight", nullable = false)
    private double weight;
    @Column(name = "Price", nullable = false)
    private double price;
    @Column(name = "PromotionalPrice", nullable = false)
    private double promotionalPrice;
    @Column(name = "Description", nullable = false)
    private String description;
    @ManyToOne(optional = false)
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
