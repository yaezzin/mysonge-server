package com.sook.mysonge.web.dto.routine;

import com.sook.mysonge.domain.routine.Routine;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class RoutineResponseDto {
    private Long id;
    private String name;
    private int Sunday;
    private int Monday;
    private int Tuesday;
    private int Wednesday;
    private int Thursday;
    private int Friday;
    private int Saturday;
    private LocalTime routineTime;
    private String context;
    private Boolean achieve;

    public RoutineResponseDto(Routine entity){
        this.name = entity.getName();
        this.Sunday = entity.getSunday();
        this.Monday = entity.getMonday();
        this.Tuesday = entity.getTuesday();
        this.Wednesday = entity.getWednesday();
        this.Thursday = entity.getThursday();
        this.Friday = entity.getFriday();
        this.Saturday = entity.getSaturday();
        this.routineTime = entity.getRoutineTime();
        this.context = entity.getContext();
        this.achieve = entity.getAchieve();
    }
}
