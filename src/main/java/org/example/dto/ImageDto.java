    package org.example.dto;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import lombok.ToString;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public class ImageDto {
        private Long id;
        private Long vehicleId;
        private String imageUrl;
        private Boolean isMainImage;
    }
