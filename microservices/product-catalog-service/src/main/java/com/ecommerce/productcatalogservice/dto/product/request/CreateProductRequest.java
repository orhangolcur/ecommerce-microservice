package com.ecommerce.productcatalogservice.dto.product.request;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.ecommerce.productcatalogservice.entity.ProductStatus;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateProductRequest(
    @NotBlank @Size(max = 255) String name,
    String description,
    @NotNull UUID categoryId,
    @NotNull @Positive @Digits(integer = 8, fraction = 2) BigDecimal basePrice,
    ProductStatus status,
    @Valid List<CreateProductImageRequest> images,
    @NotEmpty @Valid List<CreateProductVariantRequest> variants
) {

}
