package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VehicleImageDto {
    private Long vehicleId;
    private String mainImageUrl;
    private List<String> additionalImageUrls;
}
