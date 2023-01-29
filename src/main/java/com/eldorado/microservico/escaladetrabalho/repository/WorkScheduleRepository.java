package com.eldorado.microservico.escaladetrabalho.repository;


import com.eldorado.microservico.escaladetrabalho.model.WorkScheduleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface WorkScheduleRepository extends MongoRepository<WorkScheduleEntity, UUID> {
    Optional<WorkScheduleEntity> findByEmployeeId(UUID id);
}
