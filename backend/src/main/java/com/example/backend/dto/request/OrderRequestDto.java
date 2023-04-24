package com.example.backend.dto.request;

import com.example.backend.model.Status;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderRequestDto {
    private Long carId;
    private String problemDescription;
    private LocalDateTime startDate;
    private List<Long> serviceForCarsId;
    private List<Long> productsId;
    private Status status;
    private double price;
    private LocalDateTime finishDate;
}
