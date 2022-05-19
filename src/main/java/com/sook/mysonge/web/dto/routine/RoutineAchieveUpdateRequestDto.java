package com.sook.mysonge.web.dto.routine;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RoutineAchieveUpdateRequestDto {
    private Boolean achieve;

    @Builder
    public RoutineAchieveUpdateRequestDto(Boolean achieve){
        this.achieve = achieve;
    }
}
