package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VehicleImageDto {
    private Long id;
    private Long vehicleId;
    private String imageUral;
    private Boolean isMainImage;
}
