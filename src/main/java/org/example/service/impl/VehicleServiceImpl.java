//package org.example.service.impl;
//
//import lombok.RequiredArgsConstructor;
//import org.example.dto.VehicleDto;
//import org.example.repository.VehicleRepository;
//import org.example.service.VehicleService;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//import java.util.List;
//@RequiredArgsConstructor
//@Service
//public class VehicleServiceImpl implements VehicleService {
//
//    final VehicleRepository repository;
//    final VehicleService service;
//    final ModelMapper mapper;
//    @Override
//    public Long addVehicle(VehicleDto vehicleDto) {
//        return null;
//    }
//
//    @Override
//    public boolean updateVehicle(VehicleDto userDto) {
//        return false;
//    }
//
//    @Override
//    public boolean deleteVehicle(Long id) {
//        return false;
//    }
//
//    @Override
//    public List<VehicleDto> getAllVehicle() {
//        return null;
//    }
//
//    @Override
//    public VehicleDto searchVehicleById(Long id) {
//        return null;
//    }
//
//    @Override
//    public VehicleDto searchByUser(String email) {
//        return null;
//    }
//    public boolean isExistVehicle(VehicleDto vehicleDto) {
//        return repository.existsByRegNo(vehicleDto.getRegNo());
//    }
//}
