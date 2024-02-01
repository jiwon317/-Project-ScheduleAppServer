package com.sparta.schedulemanagementapp.controller;

import com.sparta.schedulemanagementapp.dto.ScheduleRequestDto;
import com.sparta.schedulemanagementapp.dto.ScheduleResponseDto;
import com.sparta.schedulemanagementapp.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;


    @PostMapping("/schedule")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.createSchedule(requestDto);
    }

    @GetMapping("/schedule")
    public List<ScheduleResponseDto> getSchedule() {
        return scheduleService.getSchedule();
    }

    @GetMapping("/schedule/contents")
    public ScheduleResponseDto getScheduleByKeyword(Long id) {
        return scheduleService.getScheduleByKeyword(id);
    }

    @PutMapping("/schedule/{id}")
    public Long updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.updateSchedule(id, requestDto);
    }

    @DeleteMapping("/schedule/{id}")
    public Long deleteSchedule(@PathVariable Long id) {
        return scheduleService.deleteSchedule(id);
    }
}
