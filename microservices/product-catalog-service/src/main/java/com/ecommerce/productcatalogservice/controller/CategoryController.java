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

import com.ecommerce.productcatalogservice.dto.category.request.CreateCategoryRequest;
import com.ecommerce.productcatalogservice.dto.category.response.CategoryResponse;
import com.ecommerce.productcatalogservice.entity.Category;
import com.ecommerce.productcatalogservice.mapper.CategoryMapper;
import com.ecommerce.productcatalogservice.repository.CategoryRepository;

import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/api/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryController(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping 
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toResponse)
                .toList();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse createCategory(@Valid @RequestBody CreateCategoryRequest category) {
        Category newCategory = categoryMapper.toEntity(category);
        Category savedCategory = categoryRepository.save(newCategory);
        return categoryMapper.toResponse(savedCategory);
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable UUID id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Category not found!"));
    }

}
