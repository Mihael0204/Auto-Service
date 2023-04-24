package com.example.backend.service.impl;

import com.example.backend.model.Order;
import com.example.backend.model.Owner;
import com.example.backend.repository.OwnerRepository;
import com.example.backend.service.OwnerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository repository;

    public OwnerServiceImpl(OwnerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Owner save(Owner owner) {
        return repository.save(owner);
    }

    @Override
    public Owner update(Owner owner) {
        return repository.save(owner);
    }

    @Override
    public List<Order> findAllOrdersById(Long ownerId) {
        return findById(ownerId).getOrders();
    }

    @Override
    public Owner findById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Can't find owner by id " + id));
    }

    @Override
    public List<Owner> findAll() {
        return repository.findAll();
    }
}
