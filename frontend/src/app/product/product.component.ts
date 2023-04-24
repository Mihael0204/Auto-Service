import { Component, OnInit } from '@angular/core';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  product!: Product;
  products: Product[] = [];
  title = '';
  price = 0;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts(): void {
    this.productService.getProducts()
      .subscribe(products => this.products = products);
  }

  addProduct(): void {
    this.productService.addProduct({name: this.title, price: this.price} as Product)
      .subscribe(product => {this.products.push(product)})
    this.title = '';
    this.price = 0;
  }

  updateProduct(product: Product): void {
    this.productService.updateProduct(product).subscribe();
  }

}
