import { Component, OnInit } from '@angular/core';
import { Car } from '../model/car';
import { Owner } from '../model/owner';
import { CarService } from '../service/car.service';
import { OwnerService } from '../service/owner.service';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit{
  car!: Car;
  cars: Car[] = [];
  owner_id!: number;
  owners: Owner[] = [];
  manufacture = '';
  model = '';
  year = 0;
  number = '';

  constructor(private carService: CarService,
              private ownerService: OwnerService) { }

  ngOnInit(): void {
    this.getCars();
    this.getOwners();
  }

  getCars(): void {
    this.carService.getCars()
      .subscribe(cars => this.cars = cars);
  }

  getOwners(): void {
    this.ownerService.getOwners()
      .subscribe(owners => this.owners = owners);
  }

  addCar(): void {
    this.carService.addCar({manufacture: this.manufacture,
      model: this.model,
      number: this.number,
      year: this.year,
      ownerId: this.owner_id
    } as Car)
      .subscribe(car => {this.cars.push(car)})
    this.manufacture = '';
    this.model = '';
    this.number = '';
    this.year = 0;
  }

  updateCar(car: Car): void {
    this.carService.updateCar(car).subscribe();
  }

}
