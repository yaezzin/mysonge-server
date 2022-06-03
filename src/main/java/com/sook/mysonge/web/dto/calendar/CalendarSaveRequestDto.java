package com.sook.mysonge.web.dto.calendar;

import com.sook.mysonge.domain.calendar.Calendar;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Getter
@NoArgsConstructor
public class CalendarSaveRequestDto {
    private String title;
    private String color;
    private String context;
    private String location;
    private LocalDate startYmd;
    private LocalDate endYmd;
    private LocalTime startHms;
    private LocalTime endHms;
    private Long user_id;


    @Builder
    public CalendarSaveRequestDto(String title, String color, String context, String location,
                                  LocalDate startYmd, LocalDate endYmd, LocalTime startHms, LocalTime endHms, Long user_id) {
        this.title = title;
        this.color = color;
        this.context = context;
        this.location = location;
        this.startYmd = startYmd;
        this.endYmd = endYmd;
        this.startHms = startHms;
        this.endHms = endHms;
        this.user_id = user_id;
    }

    public Calendar toEntity() {
        Calendar calendar = Calendar.builder()
                .title(title)
                .color(color)
                .location(location)
                .context(context)
                .startYmd(startYmd)
                .endYmd(endYmd)
                .startHms(startHms)
                .endHms(endHms)
                .user_id(user_id)
                .build();

        return calendar;
    }
}
