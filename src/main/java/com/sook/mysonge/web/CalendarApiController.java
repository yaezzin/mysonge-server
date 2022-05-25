package com.sook.mysonge.web;

import com.sook.mysonge.domain.calendar.Calendar;
import com.sook.mysonge.domain.calendar.CalendarRepository;
import com.sook.mysonge.domain.user.User;
import com.sook.mysonge.service.calendar.CalendarService;
import com.sook.mysonge.web.dto.calendar.CalendarResponseDto;
import com.sook.mysonge.web.dto.calendar.CalendarSaveRequestDto;
import com.sook.mysonge.web.dto.calendar.CalendarUpdateRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Api(value = "Calendar Controller", tags = "Calendar")
@RestController
@RequiredArgsConstructor
@Slf4j
public class CalendarApiController {

    private final CalendarService calendarService;
    private final CalendarRepository calendarRepository;

    @GetMapping("/calendars")
    @ApiOperation(value = "전체 캘린더 일정 조회", notes = "전체 캘린더 조회 API")
    public List<Calendar> getEventList() {
        return calendarRepository.findAll();
    }

    @GetMapping("/calendar/today")
    @ApiOperation(value = "오늘의 일정 반환", notes = "오늘 일정 조회 API by date")
    public List<Calendar> getEventsByDate() {
        return calendarRepository.findBydate();
    }

    // 1, 2, 3.. 을 클릭하면 일정 반환하도록
    @GetMapping("/calendar/{startYmd}")
    @ApiOperation(value = "날짜로 일정 조회", notes = "해당 날짜의 일정 조회 API")
    public List<Calendar> getEventsByBeginDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startYmd) {
        return calendarService.getAllByStartYmd(startYmd);
    }

    @PostMapping("/calendar")
    @ApiOperation(value = "일정 등록", notes = "캘린더 등록 API")
    public CalendarResponseDto saveEvent(@RequestBody CalendarSaveRequestDto requestDto){
        CalendarResponseDto result = calendarService.save(requestDto);
        return result;
    }

    @PutMapping("/calendar/{id}")
    @ApiOperation(value = "일정 수정", notes = "캘린더 수정 API")
    public CalendarResponseDto updateEvent(@ApiParam(value = "캘린더 id", required = true)
                                @PathVariable Long id, @RequestBody CalendarUpdateRequestDto requestDto) {
        return calendarService.update(id, requestDto);
    }

    @DeleteMapping("/calendar/{id}")
    @ApiOperation(value = "일정 삭제", notes = "캘린더 등록 API")
    public Long deleteEvent(@ApiParam(value = "캘린더 id", required = true) @PathVariable Long id) {
        calendarService.delete(id);
        return id;
    }

    @GetMapping("/all/calendars")
    public List<Calendar> getAllCalendar(){
        return calendarRepository.findAll();
    }
}