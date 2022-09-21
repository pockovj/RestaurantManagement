import { Component, OnInit } from '@angular/core';
import {filter, map, mergeMap, switchMap, tap} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import {TablesService} from "../services/tables.service";
import {CategoryService} from "../services/category.service";
import {Table} from "../model/Table";
import {Category} from "../model/Category";

@Component({
  selector: 'app-add-narachka-products',
  templateUrl: './add-narachka-products.component.html',
  styleUrls: ['./add-narachka-products.component.css']
})
export class AddNarachkaProductsComponent implements OnInit {
  category: Category | undefined
  table: Table | undefined
  constructor(private route:ActivatedRoute,private tablesService:TablesService,private categoryService:CategoryService) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(
      filter(params => params.has("categoryId")),
      map(params => +params.get("categoryId")!),
      mergeMap(p => this.categoryService.findCategoryById(p)),
    ).subscribe(data => {
      this.category = data;
    })
    this.route.paramMap.pipe(
      filter(params => params.has("id")),
      map(params => +params.get("id")!),
      mergeMap(p => this.tablesService.findTableById(p)),
    ).subscribe(data => {
      this.table = data;
    })
  }

}
