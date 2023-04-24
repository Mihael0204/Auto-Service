package com.example.backend.service;

import com.example.backend.model.ServiceForCar;
import com.example.backend.model.Status;

import java.util.List;

public interface ServiceForCarService {
    ServiceForCar save(ServiceForCar serviceForCar);

    ServiceForCar update(ServiceForCar serviceForCar);

    ServiceForCar serviceStatus(Long serviceId, ServiceForCar serviceForCar, Status status);

    ServiceForCar findById(Long id);

    List<ServiceForCar> findAll();
}
