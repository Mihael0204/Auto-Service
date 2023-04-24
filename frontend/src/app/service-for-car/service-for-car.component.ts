import { Component, OnInit } from '@angular/core';
import { ServiceForCar } from '../model/service-for-car';
import { ServiceForCarService } from '../service/service-for-car.service';
import { Master } from '../model/master';
import { MasterService } from '../service/master.service';

@Component({
  selector: 'app-service-for-car',
  templateUrl: './service-for-car.component.html',
  styleUrls: ['./service-for-car.component.css']
})
export class ServiceForCarComponent implements OnInit {
  serviceForCar!: ServiceForCar;
  serviceForCars: ServiceForCar[] = [];
  name!: string;
  price!: number;
  status!: string;
  masterId!: number;
  masters: Master[] = [];


  constructor(private serviceForCarService: ServiceForCarService,
              private masterService: MasterService) {
  }

  ngOnInit(): void {
    this.getServiceForCar();
    this.getMasters();
  }

  getServiceForCar(): void {
    this.serviceForCarService.getServiceForCar()
      .subscribe(serviceForCars => this.serviceForCars = serviceForCars);
  }

  getMasters(): void {
    this.masterService.getMasters()
      .subscribe(masters => this.masters = masters);
  }

  addService(): void {
    this.status = 'ACCEPTED'
    this.serviceForCarService.addService({price: this.price,
      name: this.name,
      masterId: this.masterId,
      status: this.status
    } as ServiceForCar)
      .subscribe(serviceForCar => {this.serviceForCars.push(serviceForCar)})
    this.name = '';
    this.price = 0;
  }
  updateService(serviceForCar: ServiceForCar): void {
    this.serviceForCarService.updateService(serviceForCar).subscribe();
  }

  changeStatus(): void {
    console.log(this.serviceForCar);
    this.serviceForCarService.changeStatus(this.serviceForCar).subscribe();
  }
}
