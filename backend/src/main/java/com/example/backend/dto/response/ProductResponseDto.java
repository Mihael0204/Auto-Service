package com.example.backend.dto.response;

import lombok.Data;

@Data
public class ProductResponseDto {
    private Long id;
    private String name;
    private double price;
}
