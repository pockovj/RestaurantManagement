import { Component, OnInit } from '@angular/core';
import {TablesService} from "../services/tables.service";
import {Table} from "../model/Table";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  tables: Table[] = []

  constructor(private tablesService: TablesService) {
  }

  ngOnInit(): void {
    this.tablesService.fetchTables().subscribe(data => this.tables = data)
  }

  izveshtaj() {
    this.tablesService.izveshtaj().subscribe(data => alert("Dneven promet: " + data + "\nData: " + new Date()));
  }
}


