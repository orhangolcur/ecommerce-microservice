package com.ecommerce.productcatalogservice.dto.product.response;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

public record ProductVariantResponse(
    UUID id,
    String sku,
    Map<String, String> attributes,
    BigDecimal price,
    BigDecimal effectivePrice,
    Integer stockQuantity,
    Integer reservedStock
) {

}
