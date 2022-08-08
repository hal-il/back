package com.halil.halil.domain.category.entity;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long category_id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "COLOR", nullable = false)
    private Color color;

    @Column(name = "SCOPE_TYPE", nullable = false)
    private ScopeType scope_type;

    @Builder
    public Category( String name, Color color, ScopeType scope_type){
        this.name = name;
        this.color = color;
        this.scope_type = scope_type;
    }
}
