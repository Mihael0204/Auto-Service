package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Car car;
    private String description;
    private LocalDateTime startDate;
    @OneToMany
    private List<ServiceForCar> serviceForCars;
    @OneToMany
    private List<Product> products;
    @Enumerated(EnumType.STRING)
    private Status status;
    private double fullPrice;
    private LocalDateTime finishDate;
}
