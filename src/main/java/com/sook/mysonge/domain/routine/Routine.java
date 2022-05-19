package com.sook.mysonge.domain.routine;

import com.sook.mysonge.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

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
    private Boolean Sunday;

    @Column
    @ColumnDefault("false")
    private Boolean Monday;

    @Column
    @ColumnDefault("false")
    private Boolean Tuesday;

    @Column
    @ColumnDefault("false")
    private Boolean Wednesday;

    @Column
    @ColumnDefault("false")
    private Boolean Thursday;

    @Column
    @ColumnDefault("false")
    private Boolean Friday;

    @Column
    @ColumnDefault("false")
    private Boolean Saturday;

    @Column(nullable = false)
    private LocalTime routineTime;

    @Column
    private String context;

    @Column
    @ColumnDefault("false")
    private Boolean achieve;

    @Builder
    public Routine(String name, Boolean Sunday, Boolean Monday, Boolean Tuesday, Boolean Wednesday, Boolean Thursday, Boolean Friday, Boolean Saturday, LocalTime routineTime, String context, Boolean achieve, User user){
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
        this.achieve = achieve;
        this.user = user;
    }

    // 루틴 내용 수정
    public void update(String name, Boolean Sunday, Boolean Monday, Boolean Tuesday, Boolean Wednesday, Boolean Thursday, Boolean Friday, Boolean Saturday, LocalTime routineTime, String context){
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

    // 루틴 수행 여부 수정
    public void achievement(Boolean achieve){
        this.achieve = achieve;
    }
}
