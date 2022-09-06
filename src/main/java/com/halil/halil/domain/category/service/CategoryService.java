package com.halil.halil.domain.category.service;

import com.halil.halil.domain.category.dto.CategoryCreateRequestDto;
import com.halil.halil.domain.category.dto.CategoryCreateResponseDto;
import com.halil.halil.domain.category.dto.CategoryDeleteRequestDto;
import com.halil.halil.domain.category.dto.CategoryDeleteResponseDto;

public interface CategoryService {
    CategoryCreateResponseDto createCategory(CategoryCreateRequestDto categoryCreateRequestDto);
    CategoryDeleteResponseDto deleteCategory(CategoryDeleteRequestDto categoryDeleteRequestDto);
}
