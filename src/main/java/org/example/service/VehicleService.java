package org.example.service;

import org.example.dto.VehicleDto;
import java.util.List;
public interface VehicleService {
    Long addVehicle(VehicleDto vehicleDto);
    boolean updateVehicle(VehicleDto vehicleDto);
    boolean deleteVehicle(Long id);
    List<VehicleDto> getAllVehicle();
    VehicleDto searchVehicleById(Long id);
    VehicleDto searchVehicleByRegNo(String regNo);
    List<VehicleDto> searchByOwner(Long ownerId);
    boolean isExistVehicle(VehicleDto vehicleDto);
}
