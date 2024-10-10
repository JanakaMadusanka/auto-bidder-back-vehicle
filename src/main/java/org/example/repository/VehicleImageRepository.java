package org.example.repository;

import org.example.entity.VehicleEntity;
import org.springframework.data.repository.CrudRepository;

public interface VehicleImageRepository extends CrudRepository<VehicleEntity,Long> {
}
