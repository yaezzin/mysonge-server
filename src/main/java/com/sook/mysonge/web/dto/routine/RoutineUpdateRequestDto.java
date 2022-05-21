package com.sook.mysonge.web.dto.routine;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class RoutineUpdateRequestDto {
    private String name;
    private int sunday;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
    private int saturday;
    private String routineTime;
    private String context;

    @Builder
    public RoutineUpdateRequestDto(String name, int sunday, int monday, int tuesday, int wednesday, int thursday, int friday,
                                   int saturday, String routineTime, String context){
        this.name = name;
        this.sunday = sunday;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.routineTime = routineTime;
        this.context = context;
    }
}
