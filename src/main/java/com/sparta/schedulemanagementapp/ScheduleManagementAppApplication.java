package com.sparta.schedulemanagementapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ScheduleManagementAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleManagementAppApplication.class, args);
    }

}

