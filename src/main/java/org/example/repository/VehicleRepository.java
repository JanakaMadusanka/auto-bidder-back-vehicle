package org.example.repository;

import org.example.entity.VehicleEntity;
import org.springframework.data.repository.CrudRepository;
public interface VehicleRepository extends CrudRepository<VehicleEntity,Long> {
    Boolean existsByRegNo(String regNo);
    VehicleEntity findByRegNo(String regNo);
}
