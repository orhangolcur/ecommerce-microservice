package com.ecommerce.productcatalogservice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.ecommerce.productcatalogservice.dto.product.request.CreateProductRequest;
import com.ecommerce.productcatalogservice.dto.product.response.ProductResponse;
import com.ecommerce.productcatalogservice.entity.Product;
import com.ecommerce.productcatalogservice.entity.ProductImage;
import com.ecommerce.productcatalogservice.entity.ProductVariant;
import com.ecommerce.productcatalogservice.mapper.ProductMapper;
import com.ecommerce.productcatalogservice.repository.ProductRepository;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/products")
public class ProductController {
    
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductController(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @GetMapping 
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable UUID id) {
        return productRepository.findById(id)
                .map(productMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Product not found!"));
    } 

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@Valid @RequestBody CreateProductRequest product) {
        Product newProduct = productMapper.toEntity(product);
        Product savedProduct = productRepository.save(newProduct);
        return productMapper.toResponse(savedProduct);
    } 

}
