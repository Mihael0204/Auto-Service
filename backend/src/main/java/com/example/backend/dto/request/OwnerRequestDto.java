package com.example.backend.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class OwnerRequestDto {
    private String name;
    private List<Long> carsId;
    private List<Long> ordersId;
}
