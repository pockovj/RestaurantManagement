import {Component, OnInit} from '@angular/core';
import {TablesService} from "./services/tables.service";
import {Table} from "./model/Table";
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'Restaurant Management';
  constructor() {
  }

}
