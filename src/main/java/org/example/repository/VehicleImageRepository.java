package org.example.repository;

import org.example.entity.VehicleImageEntity;
import org.springframework.data.repository.CrudRepository;
public interface VehicleImageRepository extends CrudRepository<VehicleImageEntity,Long> {
}
