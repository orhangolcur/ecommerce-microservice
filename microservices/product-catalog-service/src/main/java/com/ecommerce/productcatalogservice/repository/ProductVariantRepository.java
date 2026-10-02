package com.ecommerce.productcatalogservice.repository;

import com.ecommerce.productcatalogservice.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, UUID> {
}
