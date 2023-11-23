package com.dennis.onlineshopinterview.api.controller;

import com.dennis.onlineshopinterview.model.Category;
import com.dennis.onlineshopinterview.service.CategoryService;
import com.dennis.onlineshopinterview.shared.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse("Category created successfully",true), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Category> listCategories(){
        List<Category> categories = categoryService.list();
        return categories;
    }
}
