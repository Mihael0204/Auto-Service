import { Order } from './order';

export interface Master {
  id: number;
  fullName: string;
  readyOrdersId: number[];
  orders: Order[];
  salary: number;
}
