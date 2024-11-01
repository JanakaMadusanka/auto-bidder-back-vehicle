package org.example.repository;

import org.example.entity.VehicleEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface VehicleRepository extends CrudRepository<VehicleEntity,Long> {
    Boolean existsByRegNo(String regNo);
    VehicleEntity findByRegNo(String regNo);
    List<VehicleEntity> findByOwnerId(Long ownerId);
}
