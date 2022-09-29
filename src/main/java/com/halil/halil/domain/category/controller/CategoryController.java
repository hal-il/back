package com.halil.halil.domain.category.controller;

import com.halil.halil.domain.category.dto.*;
import com.halil.halil.domain.category.service.CategoryService;
import com.halil.halil.global.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@ComponentScan
public class CategoryController {
    private final CategoryService categoryService;

    @PutMapping("/update")
    ResponseEntity<CommonResponse> updateCategory(@RequestBody @Valid CategoryUpdateRequestDto categoryUpdateRequestDto){
        CategoryUpdateResponseDto categoryUpdateResponseDto = categoryService.updateCategory(categoryUpdateRequestDto);
        return new ResponseEntity<>(CommonResponse.createSuccess(categoryUpdateResponseDto),HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<CommonResponse> createCategory(@RequestBody @Valid CategoryCreateRequestDto categoryCreateRequestDto){
        CategoryCreateResponseDto categoryCreateResponseDto = categoryService.createCategory(categoryCreateRequestDto);
        return new ResponseEntity<>(CommonResponse.createSuccess(categoryCreateResponseDto), HttpStatus.OK);
    }
    @PostMapping("/delete")
    ResponseEntity<CommonResponse> deleteCategory(@RequestBody @Valid CategoryDeleteRequestDto categoryDeleteRequestDto){
        return new ResponseEntity<>(CommonResponse.createSuccess(categoryService.deleteCategory(categoryDeleteRequestDto)), HttpStatus.OK);
    }

}
