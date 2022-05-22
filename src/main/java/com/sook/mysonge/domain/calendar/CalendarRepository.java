package com.sook.mysonge.domain.calendar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    // 오늘 날짜가 시작~종료일자 사이에 있으면 반환
    @Query("select c from Calendar c where CURRENT_DATE >= c.start and CURRENT_DATE <= c.end")
    List<Calendar> findBydate();

}

