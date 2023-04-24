package com.example.backend.service;

import com.example.backend.model.Order;
import com.example.backend.model.Owner;

import java.util.List;

public interface OwnerService {
    Owner save(Owner owner);

    Owner update(Owner owner);

    List<Order> findAllOrdersById(Long ownerId);

    Owner findById(Long id);

    List<Owner> findAll();
}
