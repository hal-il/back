package com.halil.halil.domain.category.entity;

import lombok.Getter;

@Getter
public enum Color {
    BLACK(0x000000),WHTIE(0xFFFFFF),RED(0xFF0000),LIME(0x00FF00),BLUE(0x0000FF),YELLOW(0xFFFF00),BLUEGREEN(0x00FFFF),MAGENTA(0xFF00FF),SILVER(0xC0C0C0),GREY(0x808080),REDBROWN(0x800000),OLIVE(0x808000),GREEN(0x008000),PURPLE(0x800080),NAVY(0x000080);
    private final int color;
    Color(int color) {
        this.color=color;
    }
}
