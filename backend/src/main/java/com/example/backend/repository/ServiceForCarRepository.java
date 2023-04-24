package com.example.backend.repository;

import com.example.backend.model.ServiceForCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceForCarRepository extends JpaRepository<ServiceForCar, Long> {
}
