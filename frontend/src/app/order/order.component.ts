import { Component, OnInit } from '@angular/core';
import { Car } from '../model/car';
import { Order } from '../model/order';
import { OrderService } from '../service/order.service';
import { CarService } from '../service/car.service';
import { ProductService } from '../service/product.service';
import { Product } from '../model/product';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  order!: Order;
  orders: Order[] = [];
  car_id!: number;
  cars: Car[] = [];
  product_id!: number;
  products: Product[] = [];
  problemDescription = '';
  price = 0;
  status = '';
  startDate = '';
  finishDate = '';
  productsId: number[] = [];
  servicesId: number[] = [];

  constructor(private orderService: OrderService,
              private carService: CarService,
              private productService: ProductService) {
  }

  ngOnInit(): void {
    this.getOrders();
    this.getCars();
    this.getProducts();
  }

  getOrders(): void {
    this.orderService.getOrders()
      .subscribe(orders => this.orders = orders);
  }

  getCars(): void {
    this.carService.getCars()
      .subscribe(cars => this.cars = cars);
  }

  getProducts(): void {
    this.productService.getProducts()
      .subscribe(products => this.products = products);
  }

  addOrder(): void {
    this.orderService.addOrder({carId: this.car_id,
      problemDescription: this.problemDescription,
      price: this.price
    } as Order)
      .subscribe(order => {this.orders.push(order)})
    this.problemDescription = '';
    this.price = 0;
  }

  updateOrder(order: Order): void {
    this.orderService.updateOrder(order).subscribe();
  }


}
