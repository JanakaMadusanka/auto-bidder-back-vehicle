package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.VehicleImageDto;
import org.example.entity.VehicleImageEntity;
import org.example.repository.VehicleImageRepository;
import org.example.service.VehicleImageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class VehicleImageServiceImpl implements VehicleImageService {

    final VehicleImageRepository repository;
    final ModelMapper mapper;
    @Override
    public void addImage(VehicleImageDto vehicleImageDto) {

        //Create a new VehicleImageEntity object using the all-args constructor
        VehicleImageEntity mainImageEntity = new VehicleImageEntity(
                vehicleImageDto.getVehicleId(),// vehicleId from DTO
                vehicleImageDto.getMainImageUrl(),// Use the main image URL here
                true // Assuming this is the main image
        );
        repository.save(mainImageEntity);

        if (vehicleImageDto.getAdditionalImageUrls() != null && !vehicleImageDto.getAdditionalImageUrls().isEmpty()) {
            for (String imageUrl : vehicleImageDto.getAdditionalImageUrls()) {
                VehicleImageEntity additionalImageEntity = new VehicleImageEntity(
                        vehicleImageDto.getVehicleId(), // vehicleId from DTO
                        imageUrl, // Use the additional image URL here
                        false // Mark as additional image (not the main image)
                );
                repository.save(additionalImageEntity); // Save each additional image
            }
        }
    }

    @Override
    public boolean deleteImage(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<VehicleImageDto> getAllImages() {
        List<VehicleImageEntity> entityList = (List<VehicleImageEntity>) repository.findAll();
        List<VehicleImageDto> imageList = new ArrayList<>();

        for(VehicleImageEntity entity : entityList){
            imageList.add(mapper.map(entity,VehicleImageDto.class));
        }
        return imageList;
    }

    @Override
    public VehicleImageDto searchImageById(Long id) {
        return mapper.map(repository.findById(id), VehicleImageDto.class);
    }

    @Override
    public VehicleImageDto searchByVehicle(Long vehicleId) {
        List<VehicleImageEntity> entityList = repository.findByVehicleId(vehicleId);
        VehicleImageDto dto = new VehicleImageDto();
        List<String> additionalUrl = new ArrayList<>();
        for(VehicleImageEntity entity : entityList){
            if (entity.getIsMainImage()){
                dto.setMainImageUrl(entity.getImageUrl());
            }else {
                additionalUrl.add(entity.getImageUrl());
            }
        }
        dto.setAdditionalImageUrls(additionalUrl);
        return dto;
    }
}
