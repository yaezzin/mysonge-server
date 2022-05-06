package com.sook.mysonge.web;

import com.sook.mysonge.domain.calendar.Calendar;
import com.sook.mysonge.domain.calendar.CalendarRepository;
import com.sook.mysonge.service.calendar.CalendarService;
import com.sook.mysonge.web.dto.CalendarSaveRequestDto;
import com.sook.mysonge.web.dto.CalendarUpdateRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping("/calendar/{date}") //수정 예정..!!!
    @ApiOperation(value = "오늘 일정 리스트 반환", notes = "오늘의 일정 조회 API by date")
    public List<Calendar> getTodayEventsByDate(@PathVariable Date date) {
        return calendarRepository.findBydate(date);
    }

    @PostMapping("/calendar")
    @ApiOperation(value = "일정 등록", notes = "캘린더 등록 API")
    public ResponseEntity<Calendar> saveEvent(@RequestBody CalendarSaveRequestDto requestDto){
        Calendar result = calendarService.save(requestDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/calendar/{id}")
    @ApiOperation(value = "일정 수정", notes = "캘린더 수정 API")
    public Calendar updateEvent(@ApiParam(value = "캘린더 id", required = true)
                                @PathVariable Long id, @RequestBody CalendarUpdateRequestDto requestDto) {
        return calendarService.update(id, requestDto);
    }

    @DeleteMapping("/calendar/{id}")
    @ApiOperation(value = "일정 삭제", notes = "캘린더 등록 API")
    public Long deleteEvent(@ApiParam(value = "캘린더 id", required = true) @PathVariable Long id) {
        calendarService.delete(id);
        return id;
    }
}