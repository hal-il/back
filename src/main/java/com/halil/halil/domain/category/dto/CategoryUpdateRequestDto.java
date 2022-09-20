package com.halil.halil.domain.category.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CategoryUpdateRequestDto {
    @NotNull
    private Long category_id;

    @NotBlank
    private String name;

    @NotBlank
    private String scopeType;

}