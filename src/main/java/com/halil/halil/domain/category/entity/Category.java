package com.halil.halil.domain.category.entity;

import antlr.collections.List;
import com.halil.halil.domain.schedule.entity.Schedule;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;
import java.util.*;

@Entity
@Getter
@NoArgsConstructor
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

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "category",orphanRemoval = true)
    private Set<Schedule> schedule = new HashSet<Schedule>();

    public void setName(String name) {
        this.name = name;
    }
    public void setScopeType(String scopeType){
        this.scopeType = scopeType;
    }

    @Builder
    public Category(String name,Color color,String scopeType){
        this.name = name;
        this.color = color;
        this.scopeType = scopeType;
    }
}
