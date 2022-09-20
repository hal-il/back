package com.halil.halil.domain.schedule.dto;

import com.halil.halil.domain.category.entity.Category;
import com.halil.halil.domain.schedule.entity.Schedule;
import com.halil.halil.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ScheduleCreateRequestDto {
    @NotBlank
    private String contents;

    @NotBlank
    private String schedule_date;

    @NotBlank
    private String status;

    @NotNull
    private Long category_id;

    public Schedule toEntity(Category category){
        return Schedule.builder().contents(this.contents).schedule_date(this.schedule_date).status(this.status).category(category).build();

    }
}
