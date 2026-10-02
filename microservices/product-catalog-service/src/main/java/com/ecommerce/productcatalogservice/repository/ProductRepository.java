package com.ecommerce.productcatalogservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.productcatalogservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
