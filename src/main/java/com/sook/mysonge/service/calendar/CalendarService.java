package com.sook.mysonge.service.calendar;

import com.sook.mysonge.domain.calendar.Calendar;
import com.sook.mysonge.domain.calendar.CalendarRepository;
import com.sook.mysonge.web.dto.calendar.CalendarResponseDto;
import com.sook.mysonge.web.dto.calendar.CalendarSaveRequestDto;
import com.sook.mysonge.web.dto.calendar.CalendarUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CalendarService {

    private final CalendarRepository calendarRepository;

    @Transactional
    public CalendarResponseDto save(CalendarSaveRequestDto requestDto) {
        return new CalendarResponseDto(calendarRepository.save(requestDto.toEntity()));
    }

    @Transactional
    public CalendarResponseDto update(Long id, CalendarUpdateRequestDto requestDto) {
        Calendar calendar = calendarRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        calendar.update(requestDto.getTitle(), requestDto.getColor(), requestDto.getContext(), requestDto.getLocation(),
                requestDto.getStartYmd(), requestDto.getEndYmd(), requestDto.getStartHms(), requestDto.getEndHms());
        return new CalendarResponseDto(calendar);
    }

    public void delete(Long id) {
        Calendar calendar = calendarRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        calendarRepository.delete(calendar);
    }

}