package com.halil.halil.domain.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ScheduleCreateResponseDto {
    private Long category_id;
    private Long schedule_id;
}
