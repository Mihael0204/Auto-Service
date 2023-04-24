import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError} from 'rxjs/operators';
import { Product } from '../model/product';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class ProductService {
  private productUrl = 'products';

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(environment.apiUrl + this.productUrl)
      .pipe(
        catchError(this.handleError<Product[]>('getProducts()', []))
      );
  }

  addProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(environment.apiUrl + this.productUrl, product, this.httpOptions)
      .pipe(catchError(this.handleError<Product>('addProduct()')));
  }

  updateProduct(product: Product): Observable<any> {
    const url = `${environment.apiUrl}${this.productUrl}/${product.id}`
    return this.http.put(url, product, this.httpOptions).pipe(
      catchError(this.handleError<any>('updateProduct'))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}``
