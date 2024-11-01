package org.example.service;

import org.example.dto.VehicleImageDto;
import java.util.List;
public interface VehicleImageService {
    void addImage(VehicleImageDto vehicleImageDto);
    boolean deleteImage(Long id);
    List<VehicleImageDto> getAllImages();
    VehicleImageDto searchImageById(Long id);
    VehicleImageDto searchByVehicle(Long vehicleId);
}
