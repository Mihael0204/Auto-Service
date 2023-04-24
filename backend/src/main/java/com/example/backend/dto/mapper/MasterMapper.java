package com.example.backend.dto.mapper;

import com.example.backend.dto.request.MasterRequestDto;
import com.example.backend.dto.response.MasterResponseDto;
import com.example.backend.model.Master;
import com.example.backend.model.Order;
import com.example.backend.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MasterMapper {
    private final OrderService orderService;

    public MasterMapper(OrderService orderService) {
        this.orderService = orderService;
    }

    public Master toModel(MasterRequestDto requestDto) {
        Master master = new Master();
        master.setFullName(requestDto.getFullName());
        master.setCompleteOrders(requestDto.getCompletedOrdersId().stream()
                .map(orderService::findById)
                .collect(Collectors.toList()));
        return master;
    }

    public MasterResponseDto toDto(Master master) {
        MasterResponseDto dto = new MasterResponseDto();
        dto.setId(master.getId());
        dto.setFullName(master.getFullName());
        dto.setCompleteOrdersId(master.getCompleteOrders().stream()
                .map(Order::getId)
                .collect(Collectors.toList()));
        return dto;
    }
}
