package com.dennis.onlineshopinterview.repository;

import com.dennis.onlineshopinterview.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
