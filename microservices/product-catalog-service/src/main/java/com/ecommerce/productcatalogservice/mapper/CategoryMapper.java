package com.ecommerce.productcatalogservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ecommerce.productcatalogservice.dto.category.request.CreateCategoryRequest;
import com.ecommerce.productcatalogservice.dto.category.response.CategoryResponse;
import com.ecommerce.productcatalogservice.entity.Category;

@Mapper(componentModel = "spring") 
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true) 
    Category toEntity(CreateCategoryRequest request);

    CategoryResponse toResponse(Category category);
}
