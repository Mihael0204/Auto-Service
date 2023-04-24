package com.example.backend.dto.mapper;

import com.example.backend.dto.request.OwnerRequestDto;
import com.example.backend.dto.response.OwnerResponseDto;
import com.example.backend.model.Car;
import com.example.backend.model.Order;
import com.example.backend.model.Owner;
import com.example.backend.service.CarService;
import com.example.backend.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OwnerMapper {
    private final CarService carService;
    private final OrderService orderService;

    public OwnerMapper(CarService carService,
                       OrderService orderService) {
        this.carService = carService;
        this.orderService = orderService;
    }

    public Owner toModel(OwnerRequestDto requestDto) {
        Owner owner = new Owner();
        owner.setName(requestDto.getName());
        owner.setCars(requestDto.getCarsId().stream()
                .map(carService::findById)
                .collect(Collectors.toList()));
        owner.setOrders(requestDto.getOrdersId().stream()
                .map(orderService::findById)
                .collect(Collectors.toList()));
        return owner;
    }

    public OwnerResponseDto toDto(Owner owner) {
        OwnerResponseDto dto = new OwnerResponseDto();
        dto.setId(owner.getId());
        dto.setName(owner.getName());
        dto.setCarsId(owner.getCars().stream()
                .map(Car::getId)
                .collect(Collectors.toList()));
        dto.setOrdersId(owner.getOrders().stream()
                .map(Order::getId)
                .collect(Collectors.toList()));
        return dto;
    }
}
