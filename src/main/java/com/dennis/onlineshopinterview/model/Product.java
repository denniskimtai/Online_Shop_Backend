package com.dennis.onlineshopinterview.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer id;

    private String productName;
    private String productImageUrl;
    private double weight;
    private double price;
    private double promotionalPrice;

}
