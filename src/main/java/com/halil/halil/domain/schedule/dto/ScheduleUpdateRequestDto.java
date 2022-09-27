package com.halil.halil.domain.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ScheduleUpdateRequestDto {
    @NotNull
    private Long schedule_id;

    @NotNull
    private Long category_id;

    @NotBlank
    private String contents;

    @NotBlank
    private String schedule_date;
}
