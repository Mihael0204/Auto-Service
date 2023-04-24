import { Order } from './order';

export interface Owner {
  id: number;
  name: string;
  carsId: number[];
  ordersId: number[];

  orders: Order[];
}
