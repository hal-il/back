package com.halil.halil.domain.category.service;

import com.halil.halil.domain.category.dto.CategoryCreateRequestDto;
import com.halil.halil.domain.category.dto.CategoryCreateResponseDto;

public interface CategoryService {
    CategoryCreateResponseDto createCategory(CategoryCreateRequestDto categoryCreateRequestDto);
}
