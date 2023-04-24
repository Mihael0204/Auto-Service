import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Owner } from '../model/owner';
import { Order } from '../model/order';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class OwnerService {
  private ownerUrl = 'owners';
  private orderUrl = 'owners/orders';

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  getOwners(): Observable<Owner[]> {
    return this.http.get<Owner[]>(environment.apiUrl + this.ownerUrl)
      .pipe(
        catchError(this.handleError<Owner[]>('getOwners()', []))
      );
  }

  addOwner(owner: Owner): Observable<Owner> {
    return this.http.post<Owner>(environment.apiUrl + this.ownerUrl, owner, this.httpOptions)
      .pipe(catchError(this.handleError<Owner>('addOwner()')));
  }

  updateOwner(owner: Owner): Observable<any> {
    const url = `${environment.apiUrl}${this.ownerUrl}/${owner.id}`
    return this.http.put(url, owner, this.httpOptions).pipe(
      catchError(this.handleError<any>('updateOwner'))
    );
  }

  getOrders(owner: Owner): Observable<Order[]> {
    const url = `${environment.apiUrl}${this.orderUrl}/${owner.id}`
    return this.http.get<Order[]>(url)
      .pipe(
        catchError(this.handleError<Order[]>('getOrders()', []))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
