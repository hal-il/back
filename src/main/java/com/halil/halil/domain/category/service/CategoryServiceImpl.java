package com.halil.halil.domain.category.service;


import com.halil.halil.domain.category.dto.CategoryCreateRequestDto;
import com.halil.halil.domain.category.dto.CategoryCreateResponseDto;
import com.halil.halil.domain.category.dto.CategoryDeleteRequestDto;
import com.halil.halil.domain.category.dto.CategoryDeleteResponseDto;
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
        CategoryCreateResponseDto categoryCreateResponseDto = new CategoryCreateResponseDto().builder().category_id(category.getCategory_id()).color(category.getColor()
        ).build();
        return categoryCreateResponseDto;
    }
    @Override
    public CategoryDeleteResponseDto deleteCategory(CategoryDeleteRequestDto categoryDeleteRequestDto){
        categoryRepository.deleteById(categoryDeleteRequestDto.getCategory_id());
        return new CategoryDeleteResponseDto(categoryDeleteRequestDto.getCategory_id());
    }
}
