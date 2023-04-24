import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Master } from '../model/master';
import { Order } from '../model/order';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class MasterService {
  private masterUrl = 'masters';
  private orderUrl = 'masters/orders';

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  getMasters(): Observable<Master[]> {
    return this.http.get<Master[]>(environment.apiUrl + this.masterUrl)
      .pipe(
        catchError(this.handleError<Master[]>('getMasters()', []))
      );
  }

  addMaster(master: Master): Observable<Master> {
    return this.http.post<Master>(environment.apiUrl + this.masterUrl, master, this.httpOptions)
      .pipe(catchError(this.handleError<Master>('addMaster()')));
  }

  updateMaster(master: Master): Observable<any> {
    const url = `${environment.apiUrl}${this.masterUrl}/${master.id}`
    return this.http.put(url, master, this.httpOptions).pipe(
      catchError(this.handleError<any>('updateOwner'))
    );
  }

  getOrders(master: Master): Observable<Order[]> {
    const url = `${this.orderUrl}/${master.id}`
    return this.http.get<Order[]>(url)
      .pipe(
        catchError(this.handleError<Order[]>('getOrders()', []))
      );
  }

  getSalary(master: Master): Observable<number> {
    const url = `${this.orderUrl}/salary`
    return this.http.get<number>(url)
      .pipe(
        catchError(this.handleError<number>('getSalary()'))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
