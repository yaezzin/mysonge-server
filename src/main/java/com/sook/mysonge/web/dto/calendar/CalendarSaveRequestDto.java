package com.sook.mysonge.web.dto.calendar;

import com.sook.mysonge.domain.calendar.Calendar;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class CalendarSaveRequestDto {
    private String title;
    private String color;
    private String context;
    private String location;
    private LocalDateTime start;
    private LocalDateTime end;

    @Builder
    public CalendarSaveRequestDto(String title, String color, String context, String location,
                                  LocalDateTime start, LocalDateTime end) {
        this.title = title;
        this.color = color;
        this.context = context;
        this.location = location;
        this.start = start;
        this.end = end;
    }

    public Calendar toEntity() {
        Calendar calendar = Calendar.builder()
                .title(title)
                .color(color)
                .location(location)
                .context(context)
                .start(start)
                .end(end)
                .start(start)
                .end(end)
                .build();

        return calendar;
    }

}
