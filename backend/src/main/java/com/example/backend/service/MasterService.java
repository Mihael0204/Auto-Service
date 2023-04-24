package com.example.backend.service;

import com.example.backend.model.Master;
import com.example.backend.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MasterService {
    Master save(Master master);

    Master update(Master master);

    List<Order> getCompletedOrdersById(Long masterId);

    double getSalary(Long masterId);

    Master findById(Long id);

    List<Master> findAll();
}
