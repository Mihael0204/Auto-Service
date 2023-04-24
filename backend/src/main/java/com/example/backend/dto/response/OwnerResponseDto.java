package com.example.backend.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class OwnerResponseDto {
    private Long id;
    private String name;
    private List<Long> carsId;
    private List<Long> ordersId;
}
