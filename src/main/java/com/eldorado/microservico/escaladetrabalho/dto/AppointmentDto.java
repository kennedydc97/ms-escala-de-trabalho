package com.eldorado.microservico.escaladetrabalho.dto;

import com.eldorado.microservico.escaladetrabalho.utils.DaysOfTheWeek;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppointmentDto {

    private UUID employeeId;
    private int timeOfTheAppointment;
    private DaysOfTheWeek dayOfTheAppointment;

    private LocalDate dateOfTheAppointment;

    public String successMessage() {
        return String.format("Appointment schedule successfully made for the date:%n%s", dateOfTheAppointment);
    }
}
