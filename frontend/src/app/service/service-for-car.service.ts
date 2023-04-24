import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ServiceForCar } from '../model/service-for-car';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class ServiceForCarService {
  private serviceUrl = 'services';
  private statusUrl = 'services/update-status';

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  getServiceForCar(): Observable<ServiceForCar[]> {
    return this.http.get<ServiceForCar[]>(environment.apiUrl + this.serviceUrl)
      .pipe(
        catchError(this.handleError<ServiceForCar[]>('getServices()', []))
      );
  }

  addService(serviceForCar: ServiceForCar): Observable<ServiceForCar> {
    return this.http.post<ServiceForCar>(environment.apiUrl + this.serviceUrl, serviceForCar, this.httpOptions)
      .pipe(catchError(this.handleError<ServiceForCar>('addService()')));
  }

  updateService(serviceForCar: ServiceForCar): Observable<any> {
    const url = `${environment.apiUrl}${this.serviceUrl}/${serviceForCar.id}`
    return this.http.put(url, serviceForCar, this.httpOptions).pipe(
      catchError(this.handleError<any>('updateProduct()'))
    );
  }

  changeStatus(serviceForCar: ServiceForCar): Observable<any> {
    alert(serviceForCar.status)
    const url = `${environment.apiUrl}${this.statusUrl}/${serviceForCar.id}`
    return this.http.put(url, serviceForCar, this.httpOptions).pipe(
      catchError(this.handleError<any>('changeStatus()'))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
