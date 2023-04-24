package com.example.backend.dto.mapper;

import com.example.backend.dto.request.ServiceForCarRequestDto;
import com.example.backend.dto.response.ServiceForCarResponseDto;
import com.example.backend.model.ServiceForCar;
import com.example.backend.service.MasterService;
import com.example.backend.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class ServiceForCarMapper {
    private final OrderService orderService;
    private final MasterService masterService;

    public ServiceForCarMapper(OrderService orderService, MasterService masterService) {
        this.orderService = orderService;
        this.masterService = masterService;
    }

    public ServiceForCar mapToModel(ServiceForCarRequestDto dto) {
        ServiceForCar serviceForCar = new ServiceForCar();
        if (dto.getOrderId() != null) {
            serviceForCar.setOrder(orderService.findById(dto.getOrderId()));
        }
        serviceForCar.setMaster(masterService.findById(dto.getMasterId()));
        serviceForCar.setPrice(dto.getPrice());
        serviceForCar.setStatus(dto.getStatus());
        serviceForCar.setName(dto.getName());
        return serviceForCar;
    }

    public ServiceForCarResponseDto mapToDto(ServiceForCar serviceForCar) {
        ServiceForCarResponseDto serviceForCarResponseDto = new ServiceForCarResponseDto();
        serviceForCarResponseDto.setId(serviceForCar.getId());
        if (serviceForCarResponseDto.getOrderId() != null) {
            serviceForCarResponseDto.setOrderId(serviceForCar.getOrder().getId());
        }
        serviceForCarResponseDto.setMasterId(serviceForCar.getMaster().getId());
        serviceForCarResponseDto.setPrice(serviceForCar.getPrice());
        serviceForCarResponseDto.setStatus(serviceForCar.getStatus());
        serviceForCarResponseDto.setName(serviceForCar.getName());
        return serviceForCarResponseDto;
    }
}
