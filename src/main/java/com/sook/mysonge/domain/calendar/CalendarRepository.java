package com.sook.mysonge.domain.calendar;

import com.sook.mysonge.web.dto.calendar.CalendarResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    // 오늘 날짜가 시작~종료일자 사이에 있으면 반환
    @Query("select c from Calendar c where CURRENT_DATE >= c.startYmd and CURRENT_DATE <= c.endYmd")
    List<Calendar> findBydate();

    // 해당 날짜로 조회
    List<Calendar> findAllByStartYmd(LocalDate startYmd);

}

