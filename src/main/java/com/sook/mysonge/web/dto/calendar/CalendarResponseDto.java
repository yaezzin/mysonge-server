package com.sook.mysonge.web.dto.calendar;

import com.sook.mysonge.domain.calendar.Calendar;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class CalendarResponseDto {
    private String title;
    private String color;
    private String context;
    private String location;
    private LocalDateTime start;
    private LocalDateTime end;

    public CalendarResponseDto(Calendar calendar) {
        this.title = calendar.getTitle();
        this.color = calendar.getColor();
        this.context = calendar.getContext();
        this.location = calendar.getLocation();
        this.start = calendar.getStart();
        this.end = calendar.getEnd();

    }
}
