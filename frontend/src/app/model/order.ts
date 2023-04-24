export interface Order {
  id: number;
  carId: number;
  problemDescription: string;
  startDate: string;
  servicesId: number[];
  productsId: number[];
  status: string;
  price: number;
  finishDate: string;
}
