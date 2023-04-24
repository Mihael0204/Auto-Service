package com.example.backend.service;

import com.example.backend.model.Order;
import com.example.backend.model.Product;
import com.example.backend.model.Status;

import java.util.List;

public interface OrderService {
    Order save(Order order);

    Order addProductToOrder(Long orderId, Product product);

    Order update(Order order);

    Order orderStatus(Long orderId, Status status);

    Order getOrderPrice(Long orderId);

    Order findById(Long id);

    List<Order> findAll();
}
