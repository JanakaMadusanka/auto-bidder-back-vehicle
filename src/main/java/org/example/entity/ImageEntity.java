package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long vehicleId;
    private String imageUrl;
    private Boolean isMainImage;

    public ImageEntity(Long vehicleId, String imageUrl, Boolean isMainImage) {
        this.vehicleId = vehicleId;
        this.imageUrl = imageUrl;
        this.isMainImage = isMainImage;
    }
}
