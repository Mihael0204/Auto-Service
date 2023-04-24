package com.example.backend.service;

import com.example.backend.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    Car save(Car car);

    Car update(Car car);

    Car findById(Long id);

    List<Car> findAll();
}
