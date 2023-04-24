package com.example.backend.dto.mapper;

import com.example.backend.dto.request.OrderRequestDto;
import com.example.backend.dto.response.OrderResponseDto;
import com.example.backend.model.Order;
import com.example.backend.model.Product;
import com.example.backend.model.ServiceForCar;
import com.example.backend.service.CarService;
import com.example.backend.service.ProductService;
import com.example.backend.service.ServiceForCarService;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper {
    private final CarService carService;
    private final ServiceForCarService serviceForCarService;
    private final ProductService productService;

    public OrderMapper(CarService carService,
                       ServiceForCarService serviceForCarService,
                       ProductService productService) {
        this.carService = carService;
        this.serviceForCarService = serviceForCarService;
        this.productService = productService;
    }

    public Order toModel(OrderRequestDto requestDto) {
        Order order = new Order();
        order.setCar(carService.findById(requestDto.getCarId()));
        order.setDescription(requestDto.getProblemDescription());
        order.setStartDate(requestDto.getStartDate());
        order.setStatus(requestDto.getStatus());
        order.setFullPrice(requestDto.getPrice());
        order.setFinishDate(requestDto.getFinishDate());
        order.setProducts(requestDto.getProductsId().stream()
                .map(productService::findById)
                .collect(Collectors.toList()));
        order.setServiceForCars(requestDto.getServiceForCarsId()
                .stream().map(serviceForCarService::findById)
                .collect(Collectors.toList()));
        return order;
    }

    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setDescription(order.getDescription());
        orderResponseDto.setStartDate(order.getStartDate());
        orderResponseDto.setCarId(order.getCar().getId());
        orderResponseDto.setFullPrice(order.getFullPrice());
        orderResponseDto.setProductsId(order.getProducts().stream()
                .map(Product::getId)
                .collect(Collectors.toList()));
        orderResponseDto.setServiceForCarId(order.getServiceForCars().stream()
                .map(ServiceForCar::getId)
                .collect(Collectors.toList()));
        orderResponseDto.setStatus(order.getStatus().name());
        orderResponseDto.setFinishDate(order.getFinishDate());
        return orderResponseDto;
    }
}
