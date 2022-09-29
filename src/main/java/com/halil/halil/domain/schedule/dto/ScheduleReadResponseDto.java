package com.halil.halil.domain.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ScheduleReadResponseDto {
    private Long schedule_id;
    private String contents;
    private String date;
    private String status;
}
