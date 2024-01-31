package com.sparta.schedulemanagementapp.controller;

import com.sparta.schedulemanagementapp.dto.ScheduleRequestDto;
import com.sparta.schedulemanagementapp.dto.ScheduleResponseDto;
import com.sparta.schedulemanagementapp.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {
    // MemoController -> MemoService -> MemoRepository (강한 결합)
    private final com.sparta.schedulemanagementapp.service.ScheduleService scheduleService;

    public ScheduleController(com.sparta.schedulemanagementapp.service.ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/schedule")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return ScheduleService.createSchedule(requestDto);
    }

    @GetMapping("/schedule")
    public List<ScheduleResponseDto> getSchedule() {
        return scheduleService.getSchedule();
    }

    @GetMapping("/schedule/contents")
    public List<ScheduleResponseDto> getScheduleByKeyword(String keyword) {
        return scheduleService.getScheduleByKeyword(keyword);
    }
    @GetMapping("/schedule/title")
    public List<ScheduleResponseDto> getScheduleByKeyword(String keyword) {
        return scheduleService.getScheduleByKeyword(keyword);
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
