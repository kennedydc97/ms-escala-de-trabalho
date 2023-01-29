package com.eldorado.microservico.escaladetrabalho.controller;

import com.eldorado.microservico.escaladetrabalho.dto.AppointmentDto;
import com.eldorado.microservico.escaladetrabalho.dto.WorkScheduleDto;
import com.eldorado.microservico.escaladetrabalho.service.WorkScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/work-schedule")
public class WorkScheduleController {

    private final WorkScheduleService workScheduleService;

    @PostMapping
    public ResponseEntity<?> createWorkSchedule(@RequestBody WorkScheduleDto workScheduleDto){
        return null;
    }

    @PostMapping("/appointment")
    public ResponseEntity<?> createAnAppointment(@RequestBody AppointmentDto appointmentDto){
        return ResponseEntity.ok(workScheduleService.createAnAppointment(appointmentDto));
    }


}
