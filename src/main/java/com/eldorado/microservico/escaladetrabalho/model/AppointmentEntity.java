package com.eldorado.microservico.escaladetrabalho.model;

import com.eldorado.microservico.escaladetrabalho.utils.DaysOfTheWeek;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("appointment")
public class AppointmentEntity {

    @Id
    private UUID id;
    private UUID employeeId;
    private int timeOfTheAppointment;
    private DaysOfTheWeek dayOfTheAppointment;
}
