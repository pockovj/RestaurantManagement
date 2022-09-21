import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Produkt} from "../model/Produkt";

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http:HttpClient) { }
  url = "/api/products"
  findProductById(id:number):Observable<Produkt> {
    return this.http.get<Produkt>(`${(this.url)}/${id}`)
  }
}
