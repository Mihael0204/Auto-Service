package com.example.backend.controller;

import com.example.backend.dto.mapper.OrderMapper;
import com.example.backend.dto.mapper.ProductMapper;
import com.example.backend.dto.request.OrderRequestDto;
import com.example.backend.dto.request.ProductRequestDto;
import com.example.backend.dto.response.OrderResponseDto;
import com.example.backend.model.Order;
import com.example.backend.model.Status;
import com.example.backend.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/orders")
public class OrderController {
    private final OrderMapper orderMapper;
    private final OrderService orderService;
    private final ProductMapper productMapper;

    public OrderController(OrderMapper orderMapper,
                           OrderService orderService,
                           ProductMapper productMapper) {
        this.orderMapper = orderMapper;
        this.orderService = orderService;
        this.productMapper = productMapper;
    }

    @PostMapping
    public OrderResponseDto create(@RequestBody OrderRequestDto orderRequestDto) {
        return orderMapper.toDto(orderService.save(orderMapper.toModel(orderRequestDto)));
    }

    @PostMapping("/products/{id}")
    public OrderResponseDto addProductToOrder(@PathVariable Long id,
                                              @RequestBody ProductRequestDto productRequestDto) {
        Order order = orderService.addProductToOrder(id, productMapper.toModel(productRequestDto));
        return orderMapper.toDto(order);
    }

    @PutMapping("/{id}")
    public OrderResponseDto update(@PathVariable Long id,
                                   @RequestBody OrderRequestDto orderRequestDto) {
        Order order = orderMapper.toModel(orderRequestDto);
        order.setId(id);
        return orderMapper.toDto(orderService.save(order));
    }

    @PutMapping("/{id}/status")
    public OrderResponseDto updateStatus(@PathVariable Long id,
                                         @RequestBody Status status) {
        Order order = orderService.findById(id);
        order.setId(id);
        order.setStatus(status);
        return orderMapper.toDto(orderService.save(order));
    }

    @GetMapping("/{id}/price")
    public OrderResponseDto getOrderPrice(@PathVariable Long id) {
        return orderMapper.toDto(orderService.getOrderPrice(id));
    }

    @GetMapping
    public List<OrderResponseDto> getOrders() {
        return orderService.findAll().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }
}
