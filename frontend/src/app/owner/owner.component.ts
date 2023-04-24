import { Component, OnInit } from '@angular/core';
import { Owner } from '../model/owner';
import { OwnerService } from '../service/owner.service';
import { Order } from '../model/order';

@Component({
  selector: 'app-owner',
  templateUrl: './owner.component.html',
  styleUrls: ['./owner.component.css']
})
export class OwnerComponent implements OnInit {
  owner!: Owner;
  owners: Owner[] = [];
  order!: Order;
  orders: Order[] = [];
  name!: string;
  carsId: number[] = [];
  ordersId: number[] = [];

  constructor(private ownerService: OwnerService) { }

  ngOnInit(): void {
    this.getOwners();
  }

  getOwners(): void {
    this.ownerService.getOwners()
      .subscribe(owners => this.owners = owners);
  }

  addOwner(): void {
    this.ownerService.addOwner({name: this.name, carsId: this.carsId, ordersId: this.ordersId} as Owner)
      .subscribe(owner => {this.owners.push(owner)})
    this.name = '';
  }

  updateOwner(owner: Owner): void {
    this.ownerService.updateOwner(owner).subscribe();
  }

  getOrders(owner: Owner): void {
    this.ownerService.getOrders(owner)
      .subscribe(orders => owner.orders = orders);
  }
}
