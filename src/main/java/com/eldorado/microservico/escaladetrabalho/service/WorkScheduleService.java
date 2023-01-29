package com.eldorado.microservico.escaladetrabalho.service;

import com.eldorado.commons.exceptions.NotFoundException;
import com.eldorado.microservico.escaladetrabalho.dto.AppointmentDto;
import com.eldorado.microservico.escaladetrabalho.model.WorkScheduleEntity;
import com.eldorado.microservico.escaladetrabalho.repository.AppointmentRepository;
import com.eldorado.microservico.escaladetrabalho.repository.WorkScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



@Service
@Slf4j
@RequiredArgsConstructor
public class WorkScheduleService {

    private final WorkScheduleRepository workScheduleRepository;
    private final AppointmentRepository appointmentRepository;

    private final String MESSAGE = "Hours available in the chosen day\n%s";
    private final String UNAVAILABLE_MESSAGE = "There isn't available hours for the chosen day";

    public String createAnAppointment(AppointmentDto appointmentDto){

        var employeeWorkSchedule = workScheduleRepository.findByEmployeeId(appointmentDto.getEmployeeId())
                .orElseThrow(() -> new NotFoundException("Work Schedule not found"));

        if(checkEmployeeAvailability(appointmentDto, employeeWorkSchedule)){
            employeeWorkSchedule.getAppointmentList().add(appointmentDto);
            var workScheduleEntity = workScheduleRepository.save(employeeWorkSchedule);
            log.info("Work schedule successfully saved {}", workScheduleEntity);
            return appointmentDto.successMessage();
        } else {
            return availableAppointmentHourForTheDay(employeeWorkSchedule, appointmentDto);
        }
    }

    private boolean checkEmployeeAvailability(AppointmentDto appointmentDto, WorkScheduleEntity workScheduleEntity){
        return workScheduleEntity.getAppointmentList().stream()
                .noneMatch(
                        appointment -> appointment.getDayOfTheAppointment().equals(appointmentDto.getDayOfTheAppointment())
                                && appointment.getTimeOfTheAppointment() == appointmentDto.getTimeOfTheAppointment());
    }

    private String availableAppointmentHourForTheDay(WorkScheduleEntity workSchedule, AppointmentDto appointment) {
        var appointmentListForTheDay = workSchedule.getAppointmentList()
                .stream()
                .filter(a -> a.getDateOfTheAppointment().equals(appointment.getDateOfTheAppointment()))
                .toList();

        StringBuilder availableHours = new StringBuilder();
        for(int i = workSchedule.getStartWorkingHour(); i <= workSchedule.getEndWorkingHour(); i++) {
            int finalI = i;
            if(appointmentListForTheDay.stream().noneMatch(a -> a.getTimeOfTheAppointment() == finalI)){
                if(i < 10)
                    availableHours.append(String.format("0%s:00%n", i));
                else
                    availableHours.append(String.format("%s:00%n", i));
            }
        }
        if(availableHours.length() > 0) {
            return String.format(MESSAGE, availableHours.toString());
        } else {
            return UNAVAILABLE_MESSAGE;
        }
    }


}
