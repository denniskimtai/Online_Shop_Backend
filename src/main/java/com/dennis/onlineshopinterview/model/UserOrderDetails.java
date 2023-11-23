package com.dennis.onlineshopinterview.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "OrderDetails")
public class UserOrderDetails {
    @Id
    @Column(name = "Id", nullable = false)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ProductId", nullable = false)
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(name = "OrderId", nullable = false)
    private UserOrder userOrder;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Price", nullable = false)
    private Double price;

    @Column(name = "Weight", nullable = false)
    private Double weight;

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public UserOrder getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(UserOrder userOrder) {
        this.userOrder = userOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}