package com.halil.halil.domain.category.service;


import com.halil.halil.domain.category.dto.*;
import com.halil.halil.domain.category.entity.Category;
import com.halil.halil.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.awt.*;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final EntityManager entityManager;
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
    @Override
    public CategoryUpdateResponseDto updateCategory(CategoryUpdateRequestDto categoryUpdateRequestDto){
        Category category = categoryRepository.getReferenceById(categoryUpdateRequestDto.getCategory_id());
        if (!category.getScopeType().equals(categoryUpdateRequestDto.getScopeType())){
            category.setScopeType(categoryUpdateRequestDto.getScopeType());
        }
        if (!category.getName().equals(categoryUpdateRequestDto.getName())){
            category.setName(categoryUpdateRequestDto.getName());
        }
        categoryRepository.save(category);
        return new CategoryUpdateResponseDto().builder().category_id(category.getCategory_id()).name(category.getName()).scopeType(category.getScopeType()).build();
    }
}
