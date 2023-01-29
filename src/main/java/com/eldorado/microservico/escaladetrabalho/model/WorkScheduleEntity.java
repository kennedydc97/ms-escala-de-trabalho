package com.eldorado.microservico.escaladetrabalho.model;

import com.eldorado.microservico.escaladetrabalho.dto.AppointmentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("work-schedule")
public class WorkScheduleEntity {
    @Id
    private UUID id;
    private UUID employeeId;
    private String employeeName;
    @Min(0)
    private int startWorkingHour;
    @Max(23)
    private int endWorkingHour;
    private List<AppointmentDto> appointmentList = new ArrayList<>();

}
