import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductComponent } from './product/product.component';
import { CarComponent } from './car/car.component';
import { OwnerComponent } from './owner/owner.component';
import { MasterComponent } from './master/master.component';
import { ServiceForCarComponent } from './service-for-car/service-for-car.component';
import { OrderComponent } from './order/order.component';

const routes: Routes = [
  { path: 'products', component: ProductComponent },
  { path: 'cars', component: CarComponent },
  { path: 'owners', component: OwnerComponent },
  { path: 'masters', component: MasterComponent },
  { path: 'services', component: ServiceForCarComponent },
  { path: 'orders', component: OrderComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
