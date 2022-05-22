package com.sook.mysonge.web.dto.calendar;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class CalendarUpdateRequestDto {

    private String title;
    private String color;
    private String context;
    private String location;
    private LocalDateTime start;
    private LocalDateTime end;

    @Builder
    public CalendarUpdateRequestDto(String title, String color, String context, String location,
                                    LocalDateTime start, LocalDateTime end) {
        this.title = title;
        this.color = color;
        this.context = context;
        this.location = location;
        this.start = start;
        this.end = end;
    }

}
