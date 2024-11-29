package org.example.repository;
import org.example.entity.VehicleImageEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface VehicleImageRepository extends CrudRepository<VehicleImageEntity,Long> {
    List<VehicleImageEntity> findByVehicleId(Long vehicleId);

    VehicleImageEntity findByImageUrl(String imageUrl);
}
