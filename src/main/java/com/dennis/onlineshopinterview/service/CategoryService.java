package com.dennis.onlineshopinterview.service;

import com.dennis.onlineshopinterview.model.Category;
import com.dennis.onlineshopinterview.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    public List<Category> list(){

        return categoryRepository.findAll();
    }
}
