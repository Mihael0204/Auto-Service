package com.example.backend.controller;

import com.example.backend.dto.mapper.CarMapper;
import com.example.backend.dto.request.CarRequestDto;
import com.example.backend.dto.response.CarResponseDto;
import com.example.backend.model.Car;
import com.example.backend.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    public CarController(CarService carService,
                         CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @PostMapping
    public CarResponseDto create(@RequestBody CarRequestDto carRequestDto) {
        Car car = carService.save(carMapper.toModel(carRequestDto));
        return carMapper.toDto(car);
    }

    @PutMapping("/{id}")
    public CarResponseDto update(@PathVariable Long id, @RequestBody CarRequestDto carRequestDto) {
        Car car = carMapper.toModel(carRequestDto);
        car.setId(id);
        return carMapper.toDto(car);
    }

    @GetMapping
    public List<CarResponseDto> getCars() {
        return carService.findAll().stream()
                .map(carMapper::toDto)
                .collect(Collectors.toList());
    }
}
