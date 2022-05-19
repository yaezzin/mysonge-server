package com.sook.mysonge.web.dto.routine;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class RoutineUpdateRequestDto {
    private String name;
    private Boolean Sunday;
    private Boolean Monday;
    private Boolean Tuesday;
    private Boolean Wednesday;
    private Boolean Thursday;
    private Boolean Friday;
    private Boolean Saturday;
    private LocalTime routineTime;
    private String context;

    @Builder
    public RoutineUpdateRequestDto(String name, Boolean Sunday, Boolean Monday, Boolean Tuesday, Boolean Wednesday, Boolean Thursday, Boolean Friday, Boolean Saturday, LocalTime routineTime, String context){
        this.name = name;
        this.Sunday = Sunday;
        this.Monday = Monday;
        this.Tuesday = Tuesday;
        this.Wednesday = Wednesday;
        this.Thursday = Thursday;
        this.Friday = Friday;
        this.Saturday = Saturday;
        this.routineTime = routineTime;
        this.context = context;
    }
}
