
package com.halil.halil.domain.category.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CategoryUpdateResponseDto {
    @NotNull
    private Long category_id;

    @NotBlank
    private String name;

    @NotBlank
    private String scopeType;
}
