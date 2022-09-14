package com.halil.halil.domain.category.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CategoryUpdateRequestDto {
    @NotNull
    Long category_id;

    @NotBlank
    String name;

    @NotBlank
    String scopeType;

}