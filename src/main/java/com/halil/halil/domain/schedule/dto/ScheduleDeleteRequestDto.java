package com.halil.halil.domain.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ScheduleDeleteRequestDto {
    @NotNull
    private Long schedule_id;
}
