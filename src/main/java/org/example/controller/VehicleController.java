package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.VehicleDto;
import org.example.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehicleController {
    final VehicleService service;
    @PostMapping("/register")
    public ResponseEntity<String> registerVehicle(@RequestBody VehicleDto vehicleDto) {
        try {
            service.addVehicle(vehicleDto);
            return new ResponseEntity<>("Vehicle registered successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
