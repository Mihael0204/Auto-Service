import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Order} from '../model/order';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class OrderService {
  private orderUrl = 'orders';

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  getOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(environment.apiUrl + this.orderUrl)
      .pipe(
        catchError(this.handleError<Order[]>('getOrders()', []))
      );
  }

  addOrder(order: Order): Observable<Order> {
    return this.http.post<Order>(environment.apiUrl + this.orderUrl, order, this.httpOptions)
      .pipe(catchError(this.handleError<Order>('addOrder()')));
  }

  updateOrder(order: Order): Observable<any> {
    const url = `${environment.apiUrl}${this.orderUrl}/${order.id}`
    return this.http.put(url, order, this.httpOptions).pipe(
      catchError(this.handleError<any>('updateOrder'))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
