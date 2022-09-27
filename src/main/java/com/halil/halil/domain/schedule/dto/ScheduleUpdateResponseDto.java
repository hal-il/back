package com.halil.halil.domain.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleUpdateResponseDto {
    private Long schedule_id;
    private Long category_id;
}
