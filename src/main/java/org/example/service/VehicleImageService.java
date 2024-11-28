package org.example.service;

import org.example.dto.ImageDto;
import org.example.dto.VehicleImageDto;
import java.util.List;
public interface VehicleImageService {
    void addImage(VehicleImageDto vehicleImageDto);
    boolean updateImage(ImageDto imageDto);
    boolean deleteImage(Long id);
    List<VehicleImageDto> getAllImages();
    VehicleImageDto searchImageById(Long id);
    List<VehicleImageDto> searchByVehicle(Long vehicleId);
    VehicleImageDto searchImageSetByVehicle(Long vehicleId);
}
