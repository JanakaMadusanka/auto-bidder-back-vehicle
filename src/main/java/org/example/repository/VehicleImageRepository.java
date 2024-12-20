package org.example.repository;

import org.example.entity.ImageEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface VehicleImageRepository extends CrudRepository<ImageEntity,Long> {
    List<ImageEntity> findByVehicleId(Long vehicleId);

    ImageEntity findByImageUrl(String imageUrl);
}
