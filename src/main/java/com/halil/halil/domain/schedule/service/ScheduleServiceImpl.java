package com.halil.halil.domain.schedule.service;


import com.halil.halil.domain.category.entity.Category;
import com.halil.halil.domain.category.repository.CategoryRepository;
import com.halil.halil.domain.schedule.dto.*;
import com.halil.halil.domain.schedule.entity.Schedule;
import com.halil.halil.domain.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final CategoryRepository categoryRepository;
    private final ScheduleRepository scheduleRepository;
    @Override
    public ScheduleCreateResponseDto createSchedule(ScheduleCreateRequestDto scheduleCreateRequestDto){
        Category category = categoryRepository.getReferenceById(scheduleCreateRequestDto.getCategory_id());
        Schedule schedule = scheduleCreateRequestDto.toEntity(category);
        scheduleRepository.save(schedule);
        return new ScheduleCreateResponseDto().builder().schedule_id(schedule.getSchedule_id()).category_id(category.getCategory_id()).build();
    }
    @Override
    public ScheduleDeleteResponseDto deleteSchedule(ScheduleDeleteRequestDto scheduleDeleteRequestDto){
        scheduleRepository.deleteById(scheduleDeleteRequestDto.getSchedule_id());
        return new ScheduleDeleteResponseDto().builder().schedule_id(scheduleDeleteRequestDto.getSchedule_id()).build();
    }
}
