package com.ecommerce.productcatalogservice.dto.category.response;

import java.time.Instant;
import java.util.UUID;

public record CategoryResponse(
    UUID id,
    String name,
    UUID parentCategoryId,
    Instant createdAt,
    Instant updatedAt
) {

}
