package com.example.backend.controller;

import com.example.backend.dto.mapper.ServiceForCarMapper;
import com.example.backend.dto.request.ServiceForCarRequestDto;
import com.example.backend.dto.response.ServiceForCarResponseDto;
import com.example.backend.model.ServiceForCar;
import com.example.backend.service.ServiceForCarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/services")
public class ServiceForCarController {
    private final ServiceForCarService serviceForCarService;
    private final ServiceForCarMapper serviceForCarMapper;

    public ServiceForCarController(ServiceForCarService serviceForCarService,
                                   ServiceForCarMapper serviceForCarMapper) {
        this.serviceForCarService = serviceForCarService;
        this.serviceForCarMapper = serviceForCarMapper;
    }

    @PostMapping
    public ServiceForCarResponseDto create(
            @RequestBody ServiceForCarRequestDto serviceForCarRequestDto) {
        ServiceForCar serviceForCar = serviceForCarService
                .save(serviceForCarMapper
                        .mapToModel(serviceForCarRequestDto));
        return serviceForCarMapper.mapToDto(serviceForCar);
    }

    @PutMapping("/{id}")
    public ServiceForCarResponseDto update(@PathVariable Long id,
                                           @RequestBody ServiceForCarRequestDto serviceForCarRequestDto) {
        ServiceForCar serviceForCar =
                serviceForCarMapper.mapToModel(serviceForCarRequestDto);
        serviceForCar.setId(id);
        return serviceForCarMapper
                .mapToDto(serviceForCarService.save(serviceForCar));
    }

    @PutMapping("/update-status/{id}")
    public ServiceForCarResponseDto changeStatus(@PathVariable Long id,
                                                 @RequestBody ServiceForCarRequestDto serviceForCarRequestDto) {
        ServiceForCar serviceForCar =
                serviceForCarMapper.mapToModel(serviceForCarRequestDto);
        serviceForCar.setId(id);
        return serviceForCarMapper.mapToDto(serviceForCarService.save(serviceForCar));
    }

    @GetMapping
    public List<ServiceForCarResponseDto> getServiceForCar() {
        return serviceForCarService.findAll().stream()
                .map(serviceForCarMapper::mapToDto)
                .collect(Collectors.toList());
    }


}
