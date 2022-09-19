package com.halil.halil.domain.schedule.repository;


import com.halil.halil.domain.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}