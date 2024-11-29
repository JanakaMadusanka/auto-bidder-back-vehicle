package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.ImageDto;
import org.example.dto.VehicleImageDto;
import org.example.service.VehicleImageService;
import org.example.service.VehicleService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class VehicleImageController {
    final VehicleService service;
    final VehicleImageService imageService;

    @PutMapping("/update/{id}")
    public String updateImage(@PathVariable Long id, @RequestBody ImageDto imageDto) {
        imageDto.setId(id);
        if (imageService.updateImage(imageDto)) {
            return "Updated";
        }
        return "User doesn't exist";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteImage(@PathVariable Long id){
        if(imageService.deleteImage(id)){
            return "Deleted";
        }
        return "Image doesn't exist";
    }

    @DeleteMapping("/delete-by-url/{imageUrl}")
    public String deleteImageByUrl(@PathVariable String imageUrl) {
        VehicleImageDto vehicleImageDto = imageService.searchImageByUrl(imageUrl);
        if (vehicleImageDto != null) {
            imageService.deleteImage(vehicleImageDto.getId());
            return "Deleted";
        }
        return "Image doesn't exist";
    }

}
