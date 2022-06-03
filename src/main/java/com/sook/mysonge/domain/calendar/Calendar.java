package com.sook.mysonge.domain.calendar;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.sook.mysonge.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(fetch =FetchType.LAZY)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;

    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String location;

    private String context;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startYmd; // 시작의 년, 월, 일

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endYmd; // 종료의 년, 월, 일

    @Column(nullable = false)
    //@DateTimeFormat(pattern = "HH:mm")
    private LocalTime startHms; // 시작의 시, 분, 초

    @Column(nullable = false)
    //@DateTimeFormat(pattern = "HH:mm")
    private LocalTime endHms; // 종료의 시, 분, 초

    private double x ;

    private double y;

    @Builder
    public Calendar(String title, String color, String location, String context,
                    LocalDate startYmd, LocalDate endYmd, LocalTime startHms, LocalTime endHms,Long user_id, double x, double y) {

        this.title = title;
        this.color = color;
        this.location = location;
        this.context = context;
        this.startYmd = startYmd;
        this.endYmd = endYmd;
        this.startHms = startHms;
        this.endHms = endHms;
        this.user_id = user_id;
        this.x = x;
        this.y = y;
    }

    public void update(String title, String color, String location, String context,
                       LocalDate startYmd, LocalDate endYmd, LocalTime startHms, LocalTime endHms, double x, double y) {
        this.title = title;
        this.color = color;
        this.context = context;
        this.location = location;
        this.startYmd = startYmd;
        this.endYmd = endYmd;
        this.startHms = startHms;
        this.endHms = endHms;
        this.x = x;
        this.y = y;
    }
}
