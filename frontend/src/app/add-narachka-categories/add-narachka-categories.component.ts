import {Component, OnInit} from '@angular/core';
import {filter, map, mergeMap, tap} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import {Table} from "../model/Table";
import {CategoryService} from "../services/category.service";
import {Category} from "../model/Category";
import {TablesService} from "../services/tables.service";

@Component({
  selector: 'app-add-narachka',
  templateUrl: './add-narachka-categories.component.html',
  styleUrls: ['./add-narachka-categories.component.css']
})
export class AddNarachkaCategoriesComponent implements OnInit {
  categories: Category[] = []
  table: Table | undefined

  constructor(private categoryService: CategoryService,private tablesService:TablesService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.paramMap.pipe(
      filter(params => params.has("id")),
      map(params => +params.get("id")!),
      mergeMap(p => this.tablesService.findTableById(p)),
    ).subscribe(data => {
      this.table = data;
    })
    this.categoryService.fetchCategories().subscribe(data => {
      this.categories = data;
    })

  }

}
