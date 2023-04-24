package com.example.backend.dto.request;

import lombok.Data;

@Data
public class CarRequestDto {
    private String brand;
    private String model;
    private Integer yearOfRelease;
    private String number;
    private Long ownerId;
}
