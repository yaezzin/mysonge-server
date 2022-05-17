package com.sook.mysonge.web.dto.routine;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class RoutineUpdateRequestDto {
    private String name;
    private String routineRepeat;
    private LocalTime routineTime;
    private String context;
    private Boolean achieve;

    @Builder
    public RoutineUpdateRequestDto(String name, String routineRepeat, LocalTime routineTime, String context, Boolean achieve){
        this.name = name;
        this.routineRepeat = routineRepeat;
        this.routineTime = routineTime;
        this.context = context;
        this.achieve = achieve;
    }
}
