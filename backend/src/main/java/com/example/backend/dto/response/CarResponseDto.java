package com.example.backend.dto.response;

import lombok.Data;

@Data
public class CarResponseDto {
    private Long id;
    private String brand;
    private String model;
    private Integer yearOfRelease;
    private String number;
    private Long ownerId;
}
