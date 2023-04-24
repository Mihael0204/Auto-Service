package com.example.backend.service.impl;

import com.example.backend.model.Car;
import com.example.backend.repository.CarRepository;
import com.example.backend.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository repository;

    public CarServiceImpl(CarRepository repository) {
        this.repository = repository;
    }

    @Override
    public Car save(Car car) {
        return repository.save(car);
    }

    @Override
    public Car update(Car car) {
        return repository.save(car);
    }

    @Override
    public Car findById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Can't find car by id " + id));
    }

    @Override
    public List<Car> findAll() {
        return repository.findAll();
    }
}
