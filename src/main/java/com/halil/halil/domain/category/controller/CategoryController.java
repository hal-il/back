package com.halil.halil.domain.category.controller;

import com.halil.halil.domain.category.dto.CategoryCreateRequestDto;
import com.halil.halil.domain.category.dto.CategoryCreateResponseDto;
import com.halil.halil.domain.category.service.CategoryService;
import com.halil.halil.global.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@ComponentScan
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/create")
    ResponseEntity<CommonResponse> createCategory(@RequestBody @Valid CategoryCreateRequestDto categoryCreateRequestDto){
        CategoryCreateResponseDto categoryCreateResponseDto = categoryService.createCategory(categoryCreateRequestDto);
        return new ResponseEntity<>(CommonResponse.createSuccess(categoryCreateResponseDto), HttpStatus.OK);
    }
}
