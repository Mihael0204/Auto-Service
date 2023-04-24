package com.example.backend.controller;

import com.example.backend.dto.mapper.OrderMapper;
import com.example.backend.dto.mapper.OwnerMapper;
import com.example.backend.dto.request.OwnerRequestDto;
import com.example.backend.dto.response.OrderResponseDto;
import com.example.backend.dto.response.OwnerResponseDto;
import com.example.backend.model.Owner;
import com.example.backend.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;
    private final OwnerMapper ownerMapper;
    private final OrderMapper orderMapper;

    public OwnerController(OwnerService ownerService,
                           OwnerMapper ownerMapper,
                           OrderMapper orderMapper) {
        this.ownerService = ownerService;
        this.ownerMapper = ownerMapper;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    public OwnerResponseDto create(@RequestBody OwnerRequestDto requestDto) {
        return ownerMapper.toDto(ownerService.save(ownerMapper.toModel(requestDto)));
    }

    @PutMapping("/{id}")
    public OwnerResponseDto update(@PathVariable Long id,
                                  @RequestBody OwnerRequestDto requestDto) {
        Owner owner = ownerMapper.toModel(requestDto);
        owner.setId(id);
        return ownerMapper.toDto(ownerService.save(owner));
    }

    @GetMapping("/{id}/orders")
    public List<OrderResponseDto> getAllOrdersById(@PathVariable Long id) {
        return ownerService.findById(id).getOrders().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<OwnerResponseDto> findAll() {
        return ownerService.findAll().stream()
                .map(ownerMapper::toDto)
                .collect(Collectors.toList());
    }
}
