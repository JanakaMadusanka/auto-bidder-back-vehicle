package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VehicleDto{
    private Long id;
    private Long ownerId;
    private Short categoryId;
    private String make;
    private String year;
    private String model;
    private String color;
    private String mileage;
    private String regNo;
}
