package com.dennis.onlineshopinterview.repository;

import com.dennis.onlineshopinterview.model.Category;
import com.dennis.onlineshopinterview.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
