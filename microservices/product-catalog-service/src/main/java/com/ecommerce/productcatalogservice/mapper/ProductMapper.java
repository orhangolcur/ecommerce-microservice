package com.ecommerce.productcatalogservice.mapper;

import com.ecommerce.productcatalogservice.dto.product.request.CreateProductImageRequest;
import com.ecommerce.productcatalogservice.dto.product.request.CreateProductRequest;
import com.ecommerce.productcatalogservice.dto.product.request.CreateProductVariantRequest;
import com.ecommerce.productcatalogservice.dto.product.response.ProductImageResponse;
import com.ecommerce.productcatalogservice.dto.product.response.ProductResponse;
import com.ecommerce.productcatalogservice.dto.product.response.ProductVariantResponse;
import com.ecommerce.productcatalogservice.entity.Product;
import com.ecommerce.productcatalogservice.entity.ProductImage;
import com.ecommerce.productcatalogservice.entity.ProductVariant;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Product toEntity(CreateProductRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    ProductImage toEntity(CreateProductImageRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "reservedStock", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ProductVariant toEntity(CreateProductVariantRequest request);

    @Mapping(target = "variants", expression = "java(toVariantResponses(product))")
    ProductResponse toResponse(Product product);

    ProductImageResponse toResponse(ProductImage image);

    @Mapping(target = "effectivePrice",
        expression = "java(variant.getPrice() != null ? variant.getPrice() : basePrice)")
    ProductVariantResponse toResponse(ProductVariant variant, BigDecimal basePrice);

    default List<ProductVariantResponse> toVariantResponses(Product product) {
        return product.getVariants().stream()
                .map(variant -> toResponse(variant, product.getBasePrice()))
                .toList();
    }

    @AfterMapping
    default void linkChildren(@MappingTarget Product product) {
        if (product.getImages() == null) {
            product.setImages(new ArrayList<>());
        }
        if (product.getVariants() == null) {
            product.setVariants(new ArrayList<>());
        }
        product.getImages().forEach(image -> image.setProduct(product));
        product.getVariants().forEach(variant -> variant.setProduct(product));
    }
}
