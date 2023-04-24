package com.example.backend.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponseDto {
    private Long id;
    private Long carId;
    private String description;
    private LocalDateTime startDate;
    private List<Long> serviceForCarId;
    private List<Long> productsId;
    private String status;
    private double fullPrice;
    private LocalDateTime finishDate;
}
