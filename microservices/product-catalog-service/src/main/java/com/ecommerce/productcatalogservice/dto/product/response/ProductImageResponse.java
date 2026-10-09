package com.ecommerce.productcatalogservice.dto.product.response;

import java.util.UUID;

public record ProductImageResponse(
    UUID id,
    String imageUrl,
    Integer displayOrder,
    boolean primary
) {

}
