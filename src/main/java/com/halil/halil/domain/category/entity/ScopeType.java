package com.halil.halil.domain.category.entity;

public enum ScopeType {
    NO("1"),ME("2"),FRIEND("3");
    private final String type;
    ScopeType(String type){
        this.type = type;
    }
}
