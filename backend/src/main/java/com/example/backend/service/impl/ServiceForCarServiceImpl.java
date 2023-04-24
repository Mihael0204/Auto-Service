package com.example.backend.service.impl;

import com.example.backend.model.ServiceForCar;
import com.example.backend.model.Status;
import com.example.backend.repository.ServiceForCarRepository;
import com.example.backend.service.ServiceForCarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceForCarServiceImpl implements ServiceForCarService {
    private final ServiceForCarRepository serviceForCarRepository;

    public ServiceForCarServiceImpl(ServiceForCarRepository serviceForCarRepository) {
        this.serviceForCarRepository = serviceForCarRepository;
    }

    @Override
    public ServiceForCar save(ServiceForCar serviceForCar) {
        return serviceForCarRepository.save(serviceForCar);
    }

    @Override
    public ServiceForCar update(ServiceForCar serviceForCar) {
        return serviceForCarRepository.save(serviceForCar);
    }

    @Override
    public ServiceForCar serviceStatus(Long serviceId, ServiceForCar serviceForCar, Status status) {
        return serviceForCarRepository.save(serviceForCar);
    }

    @Override
    public ServiceForCar findById(Long id) {
        return serviceForCarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find service by id " + id));
    }

    @Override
    public List<ServiceForCar> findAll() {
        return serviceForCarRepository.findAll();
    }
}