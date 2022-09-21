import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Table} from "../model/Table";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Category} from "../model/Category";
import {Produkt} from "../model/Produkt";
import {FiskalnaDto} from "../model/dto/FiskalnaDto";
import {DateTotal} from "../model/DateTotal";

@Injectable({
  providedIn: 'root'
})
export class TablesService {

  constructor(private http: HttpClient) { }
  url = "/api/tables"
  fetchTables() : Observable<Table[]> {
    return this.http.get<Table[]>(this.url)
  }
  findTableById(id:number): Observable<Table> {
    return this.http.get<Table>(`${this.url}/${id}`)
  }
  save(produkt:Produkt,kolichina:number,table:Table):Observable<boolean>{
    return this.http.post<boolean>(`${this.url}/save`,{
      id:produkt.id,
      kolichina:kolichina,
      tableId:table.id
    });
  }
  fiskalna(tableId:number):Observable<FiskalnaDto> {
    return this.http.post<FiskalnaDto>(`${this.url}/fiskalna`, {
      tableId:tableId
    });
  }
  izveshtaj():Observable<number> {
    return this.http.get<number>(`${this.url}/izveshtaj`);
  }
}
