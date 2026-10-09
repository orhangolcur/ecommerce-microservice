package com.ecommerce.productcatalogservice.dto.product.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record CreateProductImageRequest(
    @NotBlank @Size(max = 500) String imageUrl,
    @NotNull @PositiveOrZero Integer displayOrder,
    boolean primary
) {

}
