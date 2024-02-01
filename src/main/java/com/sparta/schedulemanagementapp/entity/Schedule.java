package com.sparta.schedulemanagementapp.entity;


import com.sparta.schedulemanagementapp.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Table(name = "schedule") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class Schedule extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;
    private String title;
    private String password;


    public Schedule(ScheduleRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.password = requestDto.getPassword();
    }

    public void update(ScheduleRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();

    }
}


