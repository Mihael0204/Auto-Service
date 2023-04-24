package com.example.backend.dto.response;

import com.example.backend.model.Status;
import lombok.Data;

@Data
public class ServiceForCarResponseDto {
    private Long id;
    private Long orderId;
    private Long masterId;
    private double price;
    private Status status;
    private String name;
}
