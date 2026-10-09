package com.ecommerce.productcatalogservice.dto.product.response;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.ecommerce.productcatalogservice.entity.ProductStatus;

public record ProductResponse(
    UUID id,
    String name,
    String description,
    UUID categoryId,
    BigDecimal basePrice,
    ProductStatus status,
    List<ProductImageResponse> images,
    List<ProductVariantResponse> variants,
    Instant createdAt,
    Instant updatedAt
) {

}
