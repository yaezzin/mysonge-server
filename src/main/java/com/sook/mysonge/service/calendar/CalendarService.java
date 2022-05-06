package com.sook.mysonge.service.calendar;

import com.sook.mysonge.domain.calendar.Calendar;
import com.sook.mysonge.domain.calendar.CalendarRepository;
import com.sook.mysonge.web.dto.CalendarSaveRequestDto;
import com.sook.mysonge.web.dto.CalendarUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalendarService {

    private final CalendarRepository calendarRepository;

    public Calendar save(CalendarSaveRequestDto requestDto) {
        return calendarRepository.save(requestDto.toEntity());
    }

    public Calendar update(Long id, CalendarUpdateRequestDto requestDto) {
        Calendar calendar = calendarRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        calendar.update(requestDto.getTitle(), requestDto.getColor(), requestDto.getContext(),
                requestDto.getLocation(), requestDto.getStart(), requestDto.getEnd());
        return calendar;
    }

    public void delete(Long id) {
        Calendar calendar = calendarRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        calendarRepository.delete(calendar);
    }

}