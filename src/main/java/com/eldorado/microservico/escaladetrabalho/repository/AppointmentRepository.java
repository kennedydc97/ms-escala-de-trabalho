package com.eldorado.microservico.escaladetrabalho.repository;


import com.eldorado.microservico.escaladetrabalho.model.AppointmentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface AppointmentRepository extends MongoRepository<AppointmentEntity, UUID> {
    Optional<AppointmentEntity> findById(UUID id);
}
