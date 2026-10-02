package com.ecommerce.productcatalogservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.productcatalogservice.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID>{}
