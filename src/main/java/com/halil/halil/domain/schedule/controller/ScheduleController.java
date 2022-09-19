package com.halil.halil.domain.schedule.controller;

import com.halil.halil.domain.schedule.dto.*;
import com.halil.halil.domain.schedule.service.ScheduleService;
import com.halil.halil.global.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
@ComponentScan
public class ScheduleController {
    private final ScheduleService scheduleService;
    @PostMapping("/create")
    ResponseEntity<CommonResponse> createSchedule(@RequestBody @Valid ScheduleCreateRequestDto scheduleCreateRequestDto){
        return new ResponseEntity<>(CommonResponse.createSuccess(scheduleService.createSchedule(scheduleCreateRequestDto)), HttpStatus.OK);
    }
}
