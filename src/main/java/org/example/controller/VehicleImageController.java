package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.VehicleDto;
import org.example.dto.VehicleImageDto;
import org.example.service.VehicleImageService;
import org.example.service.VehicleService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class VehicleImageController {
    final VehicleService service;
    final VehicleImageService imageService;
    @PutMapping("/update/{id}")
    public String updateImage(@PathVariable Long id, @RequestBody VehicleImageDto vehicleImageDto){
        vehicleImageDto.setId(id);
        if(imageService.updateImage(vehicleImageDto)){
            return "Updated";
        }
        return "User doesn't exist";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteImage(@PathVariable Long id){
        System.out.println("id-" + id);
        if(imageService.deleteImage(id)){
            return "Deleted";
        }
        return "User doesn't exist";
    }

    @GetMapping("/search-by-owner/{ownerId}")
    public List<VehicleDto> searchUserByOwner(@PathVariable Long ownerId){

        //vehicle list excluding images
        List<VehicleDto> vehicleList = service.searchByOwner(ownerId);

        //define new vehicle list
        List<VehicleDto> vehicle = new ArrayList<>();

        for (VehicleDto vehicleDto: vehicleList){
            Long vehicleId = vehicleDto.getId();
            VehicleImageDto vehicleImageDto = imageService.searchByVehicle(vehicleId); //get vehicle image dto
            vehicleDto.setMainImageUrl(vehicleImageDto.getMainImageUrl());
            vehicleDto.setAdditionalImageUrls(vehicleImageDto.getAdditionalImageUrls());
            vehicle.add(vehicleDto); // add vehicleDto with images to vehicle array list
        }
        return vehicle;
    }
}
