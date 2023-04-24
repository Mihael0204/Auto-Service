import { Component, OnInit } from '@angular/core';
import { Master } from '../model/master';
import { MasterService } from '../service/master.service';

@Component({
  selector: 'app-master',
  templateUrl: './master.component.html',
  styleUrls: ['./master.component.css']
})
export class MasterComponent implements OnInit {
  master!: Master;
  masters: Master[] = [];
  fullName!: string;
  readyOrdersId!: number[];
  salary!: number;

  constructor(private masterService: MasterService) { }

  ngOnInit(): void {
    this.getMasters();
  }

  getMasters(): void {
    this.masterService.getMasters()
      .subscribe(masters => this.masters = masters);
  }

  addMaster(): void {
    this.masterService.addMaster({fullName: this.fullName, readyOrdersId: this.readyOrdersId} as Master)
      .subscribe(master => {this.masters.push(master)})
    this.fullName = '';
  }

  updateMaster(master: Master): void {
    this.masterService.updateMaster(master).subscribe();
  }

  getOrders(master: Master): void {
    this.masterService.getOrders(master)
      .subscribe(orders => master.orders = orders);
  }

  getSalary(master: Master): void {
    this.masterService.getSalary(master)
      .subscribe(salary => this.salary = salary);
  }
}
