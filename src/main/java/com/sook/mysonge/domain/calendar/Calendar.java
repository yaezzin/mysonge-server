package com.sook.mysonge.domain.calendar;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sook.mysonge.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String location;

    private String context;

    @Column
    @JsonFormat(pattern = "yyyy-mm-dd kk:mm:ss")
    private LocalDateTime start;

    @Column
    @JsonFormat(pattern = "yyyy-mm-dd kk:mm:ss")
    private LocalDateTime end;

    @Builder
    public Calendar(String title, String color, String location, String context,
                    LocalDateTime start, LocalDateTime end, User user) {

        this.title = title;
        this.color = color;
        this.location = location;
        this.context = context;
        this.start = start;
        this.end = end;
        this.user = user;
    }

    public void update(String title, String color, String location, String context,
                       LocalDateTime start, LocalDateTime end) {

        this.title = title;
        this.color = color;
        this.context = context;
        this.location = location;
        this.start = start;
        this.end = end;

    }
}
