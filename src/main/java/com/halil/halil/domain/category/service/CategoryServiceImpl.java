package com.halil.halil.domain.category.service;


import com.halil.halil.domain.category.dto.CategoryCreateRequestDto;
import com.halil.halil.domain.category.dto.CategoryCreateResponseDto;
import com.halil.halil.domain.category.entity.Category;
import com.halil.halil.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryCreateResponseDto createCategory(CategoryCreateRequestDto categoryCreateRequestDto){
        Category category = categoryCreateRequestDto.toEntity();
        categoryRepository.save(category);
        return new CategoryCreateResponseDto(category.getColor());
    }
}
