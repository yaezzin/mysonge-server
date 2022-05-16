package com.sook.mysonge.web.dto.calendar;

import com.sook.mysonge.domain.calendar.Calendar;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CalendarSaveRequestDto {
    private Long id;
    private String title;
    private String color;
    private String context;
    private String location;
    private LocalDate start;
    private LocalDate end;

    @Builder
    public CalendarSaveRequestDto(String title, String color, String context,
                                  String location, LocalDate start, LocalDate end) {
        this.title = title;
        this.color = color;
        this.context = context;
        this.location = location;
        this.start = start;
        this.end = end;
    }

    public Calendar toEntity() {
        Calendar calendar = Calendar.builder()
                .id(id)
                .title(title)
                .color(color)
                .location(location)
                .context(context)
                .start(start)
                .end(end)
                .build();

        return calendar;
    }

}
