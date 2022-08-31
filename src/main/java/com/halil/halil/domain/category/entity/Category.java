package com.halil.halil.domain.category.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;

@Entity
@Getter
@Table(name = "CATEGORY")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long category_id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "COLOR", nullable = false)
    private Color color;

    @Column(name = "SCOPETYPE", nullable = false)
    private String scopeType;

    @Builder
    public Category(String name,Color color,String scopeType){
        this.name = name;
        this.color = color;
        this.scopeType = scopeType;
    }
}
