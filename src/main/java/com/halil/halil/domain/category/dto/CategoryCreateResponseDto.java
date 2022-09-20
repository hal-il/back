package com.halil.halil.domain.category.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CategoryCreateResponseDto{
    private Long category_id;
    private Color color;
}
