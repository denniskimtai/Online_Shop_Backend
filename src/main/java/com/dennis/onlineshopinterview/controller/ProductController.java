package com.dennis.onlineshopinterview.controller;

import com.dennis.onlineshopinterview.dto.ProductDto;
import com.dennis.onlineshopinterview.model.Category;
import com.dennis.onlineshopinterview.repository.CategoryRepository;
import com.dennis.onlineshopinterview.service.CategoryService;
import com.dennis.onlineshopinterview.service.ProductService;
import com.dennis.onlineshopinterview.shared.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryRepository categoryRepository;

    Optional<Category> category;

    @PostMapping("/create")
    private ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto){

        ApiResponse validation = validateProductDTO(productDto);
        if(!validation.success){
            return new ResponseEntity<>(validation, HttpStatus.BAD_REQUEST);
        }

        productService.createProduct(productDto, category.get());
        return new ResponseEntity<>(new ApiResponse("", true), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> getProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    private ApiResponse validateProductDTO(ProductDto productDto){
        category = categoryRepository
                .findById(productDto.getCategoryId());

        if(!category.isPresent()){
            return new ApiResponse("Invalid category id", false);
        }
        if(productDto.getPrice() < 0){
            return new ApiResponse("Invalid price", false);
        }
        if(productDto.getPromotionalPrice() < 0){
            return new ApiResponse("Invalid promotional price", false);
        }
        if(productDto.getWeight() < 0){
            return new ApiResponse("Invalid weight", false);
        }

        return new ApiResponse("", true);
    }
}
