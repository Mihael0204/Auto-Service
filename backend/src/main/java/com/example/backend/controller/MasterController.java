package com.example.backend.controller;

import com.example.backend.dto.mapper.MasterMapper;
import com.example.backend.dto.mapper.OrderMapper;
import com.example.backend.dto.request.MasterRequestDto;
import com.example.backend.dto.response.MasterResponseDto;
import com.example.backend.dto.response.OrderResponseDto;
import com.example.backend.model.Master;
import com.example.backend.service.MasterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/masters")
public class MasterController {
    private final MasterService masterService;
    private final MasterMapper masterMapper;
    private final OrderMapper orderMapper;

    public MasterController(MasterService masterService,
                            MasterMapper masterMapper,
                            OrderMapper orderMapper) {
        this.masterService = masterService;
        this.masterMapper = masterMapper;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    public MasterResponseDto create(@RequestBody MasterRequestDto masterRequestDto) {
        return masterMapper.toDto(masterService.save(masterMapper.toModel(masterRequestDto)));
    }

    @PutMapping("/{id}")
    public MasterResponseDto update(@PathVariable Long id,
                                    @RequestBody MasterRequestDto masterRequestDto) {
        Master master = masterMapper.toModel(masterRequestDto);
        master.setId(id);
        return masterMapper.toDto(masterService.save(master));
    }

    @GetMapping("/orders/{id}")
    public List<OrderResponseDto> getCompletedOrdersById(@PathVariable Long id) {
        return masterService.getCompletedOrdersById(id)
                .stream().map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}/salary")
    public double getSalary(@PathVariable Long id) {
        return masterService.getSalary(id);
    }

    @GetMapping
    public List<MasterResponseDto> getMasters() {
        return masterService.findAll().stream()
                .map(masterMapper::toDto)
                .collect(Collectors.toList());
    }
}
