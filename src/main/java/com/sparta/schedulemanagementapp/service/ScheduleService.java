package com.sparta.schedulemanagementapp.service;

import com.sparta.schedulemanagementapp.dto.ScheduleRequestDto;
import com.sparta.schedulemanagementapp.dto.ScheduleResponseDto;
import com.sparta.schedulemanagementapp.entity.Schedule;
import com.sparta.schedulemanagementapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
// @RequiredArgsConstructor 롬복 방식 : final 생성자 필요
public class ScheduleService { //memoService AutoWired annotation 방식

    //    @Autowired
    private final ScheduleRepository scheduleRepository;

//    @Autowired (메서드 주입방법)
//    public void setDi(MemoRepository memoRepository) {
//        this.memoRepository = memoRepository;
//    }

    public ScheduleService(ScheduleRepository scheduleRepository) {
        // 파라미터에 ApplicationContext context넣으면 수동 방법(IOC 컨테이너에 직접 접근)
        // 1. 'Bean' 이름으로 가져오기
//        MemoRepository memoRepository = (MemoRepository) context.getBean("memoRepository");
//        this.memoRepository = memoRepository;

        // 2. 'Bean' 클래스 형식으로 가져오기
//        MemoRepository memoRepository = context.getBean(MemoRepository.class);
        this.scheduleRepository = scheduleRepository;

    }

    @Transactional
    public Long updateSchedule(Long id, ScheduleRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        Schedule schedule = findSchedule(id);
        // memo 내용 수정
        schedule.update(requestDto);

        return id;
    }

    public Long deleteSchedule(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        Schedule schedule = findSchedule(id);

        // memo 삭제
        ScheduleRepository.delete(schedule);

        return id;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        // RequestDto -> Entity
        Schedule schedule = new Schedule(requestDto);

        // DB 저장
        Schedule saveSchedule = ScheduleRepository.save(schedule);

        // Entity -> ResponseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);

        return scheduleResponseDto;
    }

    public List<ScheduleResponseDto> getSchedule() {
        // DB 조회
        return scheduleRepository.findAllByOrderByModifiedAtDesc().stream().map(ScheduleResponseDto::new).toList();
    }

    public List<ScheduleResponseDto> getMemosByKeyword(String keyword) {
        return scheduleRepository.findAllByContentsContainsOrderByModifiedAtDesc(keyword).stream().map(ScheduleResponseDto::new).toList();
    }

    private Schedule findSchedule(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 일정은 존재하지 않습니다.")
        );
    }
}
