package com.halil.halil.domain.category.dto;

import com.halil.halil.domain.category.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.Random;

import javax.validation.constraints.NotBlank;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class CategoryCreateRequestDto {
    @NotBlank
    String name;

    @NotBlank
    String scopeType;

    public Category toEntity(){
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randColor = new Color(r,g,b);
        return Category.builder()
                .name(name)
                .scopeType(scopeType)
                .color(randColor)
                .build();
    }
}
