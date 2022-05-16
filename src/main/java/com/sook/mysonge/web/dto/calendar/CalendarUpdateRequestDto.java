package com.sook.mysonge.web.dto.calendar;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CalendarUpdateRequestDto {

    private String title;
    private String color;
    private String context;
    private String location;
    private LocalDate start;
    private LocalDate end;

    @Builder
    public CalendarUpdateRequestDto(String title, String color, String context,
                                    String location, LocalDate start, LocalDate end) {
        this.title = title;
        this.color = color;
        this.context = context;
        this.location = location;
        this.start = start;
        this.end = end;
    }

}
