package com.sook.mysonge.domain.calendar;

import com.sook.mysonge.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String color;

    private String location;

    private String context;

    private Date date; // 요일 수정 예정..

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime start;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime end;

    @Builder
    public Calendar(Long id, String title, String color, String location,
                    String context, LocalDateTime start, LocalDateTime end) {

        this.id = id;
        this.title = title;
        this.color = color;
        this.location = location;
        this.context = context;
        this.start = start;
        this.end = end;
    }

    public void update(String title, String color, String location,
                       String context, LocalDateTime start, LocalDateTime end) {

        this.title = title;
        this.color = color;
        this.context = context;
        this.location = location;
        this.start = start;
        this.end = end;

    }
}
