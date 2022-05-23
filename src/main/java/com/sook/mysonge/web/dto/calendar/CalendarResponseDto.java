package com.sook.mysonge.web.dto.calendar;

import com.sook.mysonge.domain.calendar.Calendar;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Getter
public class CalendarResponseDto {
    private Long id;
    private String title;
    private String color;
    private String context;
    private String location;
    private LocalDate startYmd;
    private LocalDate endYmd;
    private LocalTime startHms;
    private LocalTime endHms;

    public CalendarResponseDto(Calendar calendar) {
        this.id = calendar.getId();
        this.title = calendar.getTitle();
        this.color = calendar.getColor();
        this.context = calendar.getContext();
        this.location = calendar.getLocation();
        this.startYmd = calendar.getStartYmd();
        this.endYmd = calendar.getEndYmd();
        this.startHms = calendar.getStartHms();
        this.endHms = calendar.getEndHms();
    }
}
