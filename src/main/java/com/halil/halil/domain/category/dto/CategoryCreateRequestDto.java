package com.halil.halil.domain.category.dto;

import com.halil.halil.domain.category.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.awt.*;
import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class CategoryCreateRequestDto {
    @NotBlank
    private String name;

    @NotBlank
    private String scopeType;

    public Category toEntity(){
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        int r = (int)(Math.random()*255);
        int g = (int)(Math.random()*255);
        int b = (int)(Math.random()*255);
        Color randColor = new Color(r,g,b);
        return Category.builder()
                .name(name)
                .scopeType(scopeType)
                .color(randColor)
                .build();
    }
}
