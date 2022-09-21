import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Category} from "../model/Category";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { }
  url = "/api/categories"
  fetchCategories() : Observable<Category[]> {
    return this.http.get<Category[]>(this.url)
  }
  findCategoryById(id:number) : Observable<Category> {
    return this.http.get<Category>(this.url + '/' + id)
  }
}
