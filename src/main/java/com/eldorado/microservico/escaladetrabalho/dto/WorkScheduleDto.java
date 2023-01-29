package com.eldorado.microservico.escaladetrabalho.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkScheduleDto {

    private String employeeId;
    private String employeeName;
    @Min(0)
    private int startWorkingHour;
    @Max(23)
    private int endWorkingHour;
    private List<AppointmentDto> appointmentList = new ArrayList<>();


}
