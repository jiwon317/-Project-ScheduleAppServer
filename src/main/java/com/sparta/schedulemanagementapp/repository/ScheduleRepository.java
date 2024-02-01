package com.sparta.schedulemanagementapp.repository;

import com.sparta.schedulemanagementapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ScheduleRepository extends JpaRepository <Schedule, Long> {
    List<Schedule> findAllByOrderByModifiedAtDesc();

    List<Schedule> findAllByContentsContainsOrderByModifiedAtDesc(String keyword);
}
