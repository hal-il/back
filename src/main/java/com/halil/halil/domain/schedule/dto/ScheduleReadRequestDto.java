package com.halil.halil.domain.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ScheduleReadRequestDto {
    @NotNull
    private Long schedule_id;
}
