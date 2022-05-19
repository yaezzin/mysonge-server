package com.sook.mysonge.domain.routine;

import com.sook.mysonge.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.*;

@Getter
@NoArgsConstructor
@Entity
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false)
    private String name;

    @Column
    @ColumnDefault("false")
    private Boolean sunday;

    @Column
    @ColumnDefault("false")
    private Boolean monday;

    @Column
    @ColumnDefault("false")
    private Boolean tuesday;

    @Column
    @ColumnDefault("false")
    private Boolean wednesday;

    @Column
    @ColumnDefault("false")
    private Boolean thursday;

    @Column
    @ColumnDefault("false")
    private Boolean friday;

    @Column
    @ColumnDefault("false")
    private Boolean saturday;

    @Column(nullable = false)
    //@DateTimeFormat(pattern = "HH:mm")
    private String routineTime;

    @Column
    private String context;

    @Column
    @ColumnDefault("false")
    private Boolean achieve;

    @Builder
    public Routine(String name, Boolean sunday, Boolean monday, Boolean tuesday, Boolean wednesday, Boolean thursday, Boolean friday, Boolean saturday, String routineTime, String context, Boolean achieve, User user){
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
        this.achieve = achieve;
        this.user = user;
    }

    // 루틴 내용 수정
    public void update(String name, Boolean sunday, Boolean monday, Boolean tuesday, Boolean wednesday, Boolean thursday, Boolean friday, Boolean saturday, String routineTime, String context){
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

    // 루틴 수행 여부 수정
    public void achievement(Boolean achieve){
        this.achieve = achieve;
    }
}
