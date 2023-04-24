package com.example.backend.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class MasterResponseDto {
    private Long id;
    private String fullName;
    private List<Long> completeOrdersId;
}
