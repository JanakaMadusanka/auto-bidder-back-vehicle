package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.VehicleDto;
import org.example.dto.VehicleImageDto;
import org.example.service.VehicleImageService;
import org.example.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehicleController {
    final VehicleService service;
    final VehicleImageService imageService;
    @PostMapping("/register")
    public ResponseEntity<String> registerVehicle(@RequestBody VehicleDto vehicleDto) {
        try {
            Long vehicleId = service.addVehicle(vehicleDto);
            imageService.addImage(new VehicleImageDto(vehicleId,vehicleDto.getMainImageUrl(),vehicleDto.getAdditionalImageUrls()));
            return new ResponseEntity<>("Vehicle registered successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/update/{id}")
    public String updateVehicle(@PathVariable Long id, @RequestBody VehicleDto vehicleDto){
        vehicleDto.setId(id);
        if(service.updateVehicle(vehicleDto)){
            return "Updated";
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
