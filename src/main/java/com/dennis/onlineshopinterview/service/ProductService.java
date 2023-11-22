package com.dennis.onlineshopinterview.service;

import com.dennis.onlineshopinterview.dto.ProductDto;
import com.dennis.onlineshopinterview.model.Category;
import com.dennis.onlineshopinterview.model.Product;
import com.dennis.onlineshopinterview.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setProductImageUrl(productDto.getProductImageUrl());
        product.setPrice(productDto.getPrice());
        product.setWeight(productDto.getWeight());
        product.setPromotionalPrice(productDto.getPromotionalPrice());
        product.setCategory(category);

        productRepository.save(product);
    }

    public List<ProductDto> getProducts() {
        List<Product> allProducts = productRepository.findAll();
        List<ProductDto> allProductDto = new ArrayList<>();
        for(Product product : allProducts){
            ProductDto productDto = convertProductToProductDto(product);
            allProductDto.add(productDto);
        }
        return allProductDto;
    }
    
    private ProductDto convertProductToProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setProductName(product.getProductName());
        productDto.setProductImageUrl(product.getProductImageUrl());
        productDto.setPrice(product.getPrice());
        productDto.setWeight(product.getWeight());
        productDto.setPromotionalPrice(product.getPromotionalPrice());
        productDto.setCategoryId(product.getCategory().getId());
        
        return productDto;
    }
}
