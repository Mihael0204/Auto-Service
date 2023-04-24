package com.example.backend.dto.request;

import com.example.backend.model.Status;
import lombok.Data;

@Data
public class ServiceForCarRequestDto {
    private Long orderId;
    private Long masterId;
    private double price;
    private Status status;
    private String name;
}
