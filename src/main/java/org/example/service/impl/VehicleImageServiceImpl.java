package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.ImageDto;
import org.example.dto.VehicleImageDto;
import org.example.entity.ImageEntity;
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
        ImageEntity mainImageEntity = new ImageEntity(
                vehicleImageDto.getVehicleId(),// vehicleId from DTO
                vehicleImageDto.getMainImageUrl(),// Use the main image URL here
                true // Assuming this is the main image
        );
        repository.save(mainImageEntity);

        if (vehicleImageDto.getAdditionalImageUrls() != null && !vehicleImageDto.getAdditionalImageUrls().isEmpty()) {
            for (String imageUrl : vehicleImageDto.getAdditionalImageUrls()) {
                ImageEntity additionalImageEntity = new ImageEntity(
                        vehicleImageDto.getVehicleId(), // vehicleId from DTO
                        imageUrl, // Use the additional image URL here
                        false // Mark as additional image (not the main image)
                );
                repository.save(additionalImageEntity); // Save each additional image
            }
        }
    }

    @Override
    public boolean updateImage(ImageDto imageDto) {
        Long imageId = imageDto.getId();
        if (imageId != null){
            ImageEntity existingImage = repository.findById(imageId).orElse(null);
            if(existingImage !=null){

                // Map the DTO to the entity and Save the new Image
                ImageEntity entity = mapper.map(imageDto, ImageEntity.class);
                repository.save(entity);
                return true;
            }
        }
        return false;
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
        List<ImageEntity> entityList = (List<ImageEntity>) repository.findAll();
        List<VehicleImageDto> imageList = new ArrayList<>();

        for(ImageEntity entity : entityList){
            imageList.add(mapper.map(entity,VehicleImageDto.class));
        }
        return imageList;
    }

    @Override
    public VehicleImageDto searchImageById(Long id) {
        return mapper.map(repository.findById(id), VehicleImageDto.class);
    }

    @Override
    public VehicleImageDto searchImageByUrl(String imageUrl) {
        return mapper.map(repository.findByImageUrl(imageUrl), VehicleImageDto.class);
    }

    @Override
    public List<ImageDto> searchByVehicle(Long vehicleId) {
        List<ImageEntity> entityList = repository.findByVehicleId(vehicleId);
        List<ImageDto> dtoList = new ArrayList<>();
        for(ImageEntity entity : entityList){
            ImageDto dto = mapper.map(entity, ImageDto.class);
            dtoList.add(dto);
        }
        return dtoList;
    }

    public VehicleImageDto searchImageSetByVehicle(Long vehicleId) {
        List<ImageEntity> entityList = repository.findByVehicleId(vehicleId);
        VehicleImageDto dto = new VehicleImageDto();
        List<String> additionalUrl = new ArrayList<>();
        for(ImageEntity entity : entityList){
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
