package com.example.backend.controller;

import com.example.backend.model.*;
import com.example.backend.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InjectController {
    private final ProductService productService;
    private final CarService carService;
    private final OwnerService ownerService;
    private final MasterService masterService;
    private final OrderService orderService;
    private final ServiceForCarService serviceForCarService;

    public InjectController(ProductService productService,
                            CarService carService,
                            OwnerService ownerService,
                            MasterService masterService,
                            OrderService orderService,
                            ServiceForCarService serviceForCarService) {
        this.productService = productService;
        this.carService = carService;
        this.ownerService = ownerService;
        this.masterService = masterService;
        this.orderService = orderService;
        this.serviceForCarService = serviceForCarService;
    }

    @GetMapping("/inject")
    public String inject() {
        /** Product Injection */
        Product product1 = new Product();
        product1.setName("Product One");
        product1.setPrice(300);
        Product product2 = new Product();
        product2.setName("Product Two");
        product2.setPrice(700);
        productService.save(product1);
        productService.save(product2);

        /** Car with Owner Injection */
        Car car1 = new Car();
        car1.setBrand("BMW");
        car1.setModel("M5");
        car1.setYearOfRelease(1995);
        car1.setNumber("AA9875BB");
        Car car2 = new Car();
        car2.setBrand("Mazda");
        car2.setModel("3");
        car2.setYearOfRelease(2008);
        car2.setNumber("CC7524AI");
        carService.save(car1);
        carService.save(car2);
        Owner owner = new Owner();
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        owner.setCars(cars);
        owner.setName("Misha");
        ownerService.save(owner);
        car1.setOwner(owner);
        car2.setOwner(owner);
        carService.update(car1);
        carService.update(car2);

        /** Master Injection */
        Master master1 = new Master();
        master1.setFullName("Grisha");
        masterService.save(master1);
        Master master2 = new Master();
        master2.setFullName("Vlad");
        masterService.save(master2);
        Master master3 = new Master();
        master3.setFullName("Fitil");
        masterService.save(master3);

        /** Order Injection */
        Order order = new Order();
        order.setDescription("Broken wheel");
        order.setStartDate(LocalDateTime.now());
        order.setCar(car1);
        order.setFullPrice(600);
        order.setStatus(Status.ACCEPTED);
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        order.setProducts(products);
        orderService.save(order);
        Order order2 = new Order();
        order2.setDescription("Need tech review");
        order2.setStartDate(LocalDateTime.now());
        order2.setCar(car2);
        order2.setFullPrice(100);
        order2.setStatus(Status.ACCEPTED);
        orderService.save(order2);

        /** ServiceForCar Injection */

        ServiceForCar serviceForCar = new ServiceForCar();
        serviceForCar.setMaster(master1);
        serviceForCar.setPrice(100);
        serviceForCar.setName("First");
        serviceForCar.setStatus(Status.ACCEPTED);
        serviceForCarService.save(serviceForCar);
        ServiceForCar serviceForCar2 = new ServiceForCar();
        serviceForCar2.setMaster(master2);
        serviceForCar2.setPrice(500);
        serviceForCar2.setName("Second");
        serviceForCar2.setStatus(Status.PAID);
        serviceForCarService.save(serviceForCar2);
        ServiceForCar serviceForCar3 = new ServiceForCar();
        serviceForCar3.setMaster(master3);
        serviceForCar3.setPrice(700);
        serviceForCar3.setName("Third");
        serviceForCar3.setStatus(Status.NOT_SUCCESS);
        serviceForCarService.save(serviceForCar3);

        return "Injection Success!";
    }
}