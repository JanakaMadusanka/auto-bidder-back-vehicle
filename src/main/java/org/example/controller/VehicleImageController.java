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
        if(imageService.deleteImage(id)){
            return "Deleted";
        }
        return "User doesn't exist";
    }
}
