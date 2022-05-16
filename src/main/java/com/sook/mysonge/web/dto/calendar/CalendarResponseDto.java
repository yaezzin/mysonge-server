package com.sook.mysonge.web.dto.calendar;

import com.sook.mysonge.domain.calendar.Calendar;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CalendarResponseDto {
    private Long id;
    private String title;
    private String color;
    private String context;
    private String location;
    private LocalDate start;
    private LocalDate end;

    public CalendarResponseDto(Calendar calendar) {
        this.id = calendar.getId();
        this.title = calendar.getTitle();
        this.color = calendar.getColor();
        this.context = calendar.getContext();
        this.location = calendar.getLocation();
        this.start = calendar.getStart();
        this.end = calendar.getEnd();
    }
}
