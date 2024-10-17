package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.VehicleDto;
import org.example.entity.VehicleEntity;
import org.example.repository.VehicleRepository;
import org.example.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class VehicleServiceImpl implements VehicleService {

    final VehicleRepository repository;
    final ModelMapper mapper;
    @Override
    public Long addVehicle(VehicleDto vehicleDto) {

        //Check if a vehicle with the same Registration No already exists
        if (repository.findByRegNo(vehicleDto.getRegNo()) != null) {
            throw new IllegalArgumentException("Vehicle with the Registration No. " + vehicleDto.getRegNo() + " already exists.");
        }

        // Map the DTO to the entity and Save the new vehicle
        VehicleEntity entity = mapper.map(vehicleDto, VehicleEntity.class);
        VehicleEntity savedEntity = repository.save(entity); //Save Vehicle & Get Entity with VehicleId
        return (savedEntity.getId()); //Get VehicleId from saved vehicleEntity & return
    }

    @Override
    public boolean updateVehicle(VehicleDto vehicleDto) {
        Long vehicleId = vehicleDto.getId();
        if (vehicleId != null){
            VehicleEntity existingVehicle = repository.findById(vehicleId).orElse(null);
            if(existingVehicle !=null){

                // Map the DTO to the entity and Save the new vehicle
                VehicleEntity entity = mapper.map(vehicleDto, VehicleEntity.class);
                repository.save(entity);
                return true;

            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteVehicle(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<VehicleDto> getAllVehicle() {
        List<VehicleEntity> entityList = (List<VehicleEntity>) repository.findAll();
        List<VehicleDto> vehicleList = new ArrayList<>();

        for(VehicleEntity entity : entityList){
            vehicleList.add(mapper.map(entity,VehicleDto.class));
        }
        return vehicleList;
    }

    @Override
    public VehicleDto searchVehicleById(Long id) {
        return mapper.map(repository.findById(id), VehicleDto.class);
    }

    @Override
    public VehicleDto searchVehicleByRegNo(String regNo) {
        return mapper.map(repository.findByRegNo(regNo), VehicleDto.class);
    }

    @Override
    public VehicleDto searchByUser(String email) {
        return null;
    }
    public boolean isExistVehicle(VehicleDto vehicleDto) {
        return repository.existsByRegNo(vehicleDto.getRegNo());
    }
}
