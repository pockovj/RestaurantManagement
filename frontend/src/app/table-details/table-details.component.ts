import { Component, OnInit } from '@angular/core';
import {TablesService} from "../services/tables.service";
import {ActivatedRoute, Router} from "@angular/router";
import {filter, map, mergeMap} from "rxjs";
import {Table} from "../model/Table";
import {ProduktKolichina} from "../model/dto/ProduktKolichina";

@Component({
  selector: 'app-table-details',
  templateUrl: './table-details.component.html',
  styleUrls: ['./table-details.component.css']
})
export class TableDetailsComponent implements OnInit {
  table: Table | undefined
  produktKolichinas: ProduktKolichina[] = []
  constructor(private tablesService:TablesService,private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(
      filter(params => params.has("id")),
      map(params => +params.get("id")!),
      mergeMap((p) => this.tablesService.findTableById(p))
    ).subscribe(data => {
      this.table = data;
      this.produktKolichinas = this.table.narachki.flatMap(narachka => narachka.produktKolichina);
    })
  }
  fiskalna() {
    this.tablesService.fiskalna(this.table?.id!).subscribe(data => {
      alert("Vkupno za plakjanje: " + data.total);
      this.router.navigate(['']);
    });
  }

}
