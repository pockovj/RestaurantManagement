import { Component, OnInit } from '@angular/core';
import {filter, map, mergeMap, tap} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {TablesService} from "../services/tables.service";
import {Table} from "../model/Table";
import {ProductsService} from "../services/products.service";
import {Produkt} from "../model/Produkt";
import {CategoryService} from "../services/category.service";
import {Category} from "../model/Category";
import {Narachka} from "../model/Narachka";

@Component({
  selector: 'app-add-narachka-product-kolichina',
  templateUrl: './add-narachka-product-kolichina.component.html',
  styleUrls: ['./add-narachka-product-kolichina.component.css']
})
export class AddNarachkaProductKolichinaComponent implements OnInit {
  table: Table | undefined
  product: Produkt | undefined
  category: Category | undefined
  kolichina: number = 1
  constructor(private route: ActivatedRoute,
              private tablesService:TablesService,
              private productsService:ProductsService,
              private categoryService: CategoryService,
              private router:Router) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(
      filter(params => params.has("id")),
      map(params => +params.get("id")!),
      mergeMap(p => this.tablesService.findTableById(p)),
    ).subscribe(data => {
      this.table = data;
    })
    this.route.paramMap.pipe(
      filter(params => params.has("productId")),
      map(params => +params.get("productId")!),
      mergeMap(p => this.productsService.findProductById(p)),
      tap(data => console.log(data))
    ).subscribe(data => {
      this.product = data;
    })
    this.route.paramMap.pipe(
      filter(params => params.has("categoryId")),
      map(params => +params.get("categoryId")!),
      mergeMap(p => this.categoryService.findCategoryById(p)),
      tap(data => console.log(data))
    ).subscribe(data => {
      this.category = data;
    })
  }
  save(): void {
    this.tablesService.save(this.product!,this.kolichina,this.table!).subscribe(data => {
      if(data) {
        return this.router.navigate([`/tables/${this.table?.id}/categories`]);
      }
      return alert("There is no that much items in stock!");
    })

  }

}
