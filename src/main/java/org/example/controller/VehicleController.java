package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.VehicleDto;
import org.example.service.VehicleService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehicleController {
    final VehicleService service;
}
