package com.halil.halil.domain.category.service;

import com.halil.halil.domain.category.dto.*;

public interface CategoryService {
    CategoryCreateResponseDto createCategory(CategoryCreateRequestDto categoryCreateRequestDto);
    CategoryDeleteResponseDto deleteCategory(CategoryDeleteRequestDto categoryDeleteRequestDto);
    CategoryUpdateResponseDto updateCategory(CategoryUpdateRequestDto categoryUpdateRequestDto);
}
