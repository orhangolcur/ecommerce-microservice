package com.ecommerce.productcatalogservice.dto.category.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateCategoryRequest(
    @NotBlank @Size(max = 255) String name,
    UUID parentCategoryId
) {

}
