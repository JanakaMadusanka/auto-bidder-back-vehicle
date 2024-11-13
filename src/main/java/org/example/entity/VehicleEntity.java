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
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long ownerId;
    private Short categoryId;
    private String make;
    private String year;
    private String model;
    private String color;
    private String mileage;
    private String regNo;
    private Boolean isUnderAuction;
    private Double minBidAmount;
    private Integer auctionTimeOut;
}
