package com.halil.halil.domain.schedule.service;


import com.halil.halil.domain.category.entity.Category;
import com.halil.halil.domain.category.repository.CategoryRepository;
import com.halil.halil.domain.schedule.Exception.InvalidIdException;
import com.halil.halil.domain.schedule.dto.*;
import com.halil.halil.domain.schedule.entity.Schedule;
import com.halil.halil.domain.schedule.repository.ScheduleRepository;
import com.halil.halil.domain.user.exception.ExistNicknameException;
import com.halil.halil.global.response.CommonResponse;
import com.halil.halil.global.util.jwt.InvalidAccessTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
    @Override
    public ScheduleUpdateResponseDto updateSchedule(ScheduleUpdateRequestDto scheduleUpdateRequestDto){
        Schedule schedule = scheduleRepository.getReferenceById(scheduleUpdateRequestDto.getSchedule_id());
        Category category = categoryRepository.getReferenceById(scheduleUpdateRequestDto.getCategory_id());
        if (schedule.getCategory().getCategory_id()!=category.getCategory_id()){
            throw new InvalidIdException("Check categoryId");
        }
        scheduleRepository.save(schedule);
        return ScheduleUpdateResponseDto.builder().schedule_id(schedule.getSchedule_id()).category_id(category.getCategory_id()).build();
    }
    @Override
    public ScheduleReadResponseDto readSchedule(ScheduleReadRequestDto scheduleReadRequestDto){
        Schedule schedule = scheduleRepository.getReferenceById(scheduleReadRequestDto.getSchedule_id());
        return new ScheduleReadResponseDto().builder().schedule_id(schedule.getSchedule_id()).date(schedule.getSchedule_date()).status(schedule.getStatus()).contents(schedule.getContents()).build();
    }
}
