import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Car } from '../model/car';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class CarService {
  private carUrl = 'cars';

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  getCars(): Observable<Car[]> {
    return this.http.get<Car[]>(environment.apiUrl + this.carUrl)
      .pipe(
        catchError(this.handleError<Car[]>('getCars()', []))
      );
  }

  addCar(car: Car): Observable<Car> {
    return this.http.post<Car>(environment.apiUrl + this.carUrl, car, this.httpOptions)
      .pipe(catchError(this.handleError<Car>('addCar()')));
  }

  updateCar(car: Car): Observable<any> {
    const url = `${environment.apiUrl}${this.carUrl}/${car.id}`
    return this.http.put(url, car, this.httpOptions).pipe(
      catchError(this.handleError<any>('updateCar'))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
