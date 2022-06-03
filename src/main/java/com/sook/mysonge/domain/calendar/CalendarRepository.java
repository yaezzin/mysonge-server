package com.sook.mysonge.domain.calendar;

import com.sook.mysonge.web.dto.calendar.CalendarResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    // 오늘 날짜가 시작~종료일자 사이에 있으면 반환
    @Query("select c from Calendar c where c.user_id = :user_id and CURRENT_DATE >= c.startYmd and CURRENT_DATE <= c.endYmd")
    List<Calendar> findBydate(@Param("user_id") Long user_id);

    // 해당 날짜로 조회
    @Query("select c from Calendar c where c.user_id = :user_id and c.startYmd = :startYmd")
    List<Calendar> findAllByStartYmd(@Param("user_id") Long user_id, @Param("startYmd") LocalDate startYmd);

}

