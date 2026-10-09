package com.ecommerce.productcatalogservice.dto.product.request;

import java.math.BigDecimal;
import java.util.Map;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record CreateProductVariantRequest(
    @NotBlank @Size(max = 100) String sku,
    Map<String, String> attributes,
    @Positive @Digits(integer = 8, fraction = 2) BigDecimal price,
    @NotNull @PositiveOrZero Integer stockQuantity
) {

}
