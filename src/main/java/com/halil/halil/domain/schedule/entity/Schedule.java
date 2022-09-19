package com.halil.halil.domain.schedule.entity;

import com.halil.halil.domain.category.entity.Category;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
//(access = AccessLevel.PROTECTED)
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCHEDULE_ID")
    private Long schedule_id;

    @Column(name = "CONTENTS", nullable = false)
    private String contents;

    @Column(name = "SCHEDULE_DATE", nullable = false)
    private String schedule_date;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @Builder
    public Schedule(String contents,String schedule_date,String status,Category category){
        this.contents = contents;
        this.schedule_date = schedule_date;
        this.status = status;
        this.category = category;
    }
}
