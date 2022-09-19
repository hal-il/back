package com.halil.halil.domain.schedule.service;

import com.halil.halil.domain.category.dto.CategoryCreateRequestDto;
import com.halil.halil.domain.category.dto.CategoryCreateResponseDto;
import com.halil.halil.domain.schedule.dto.*;

public interface ScheduleService {
    ScheduleCreateResponseDto createSchedule(ScheduleCreateRequestDto scheduleCreateRequestDto);
}
