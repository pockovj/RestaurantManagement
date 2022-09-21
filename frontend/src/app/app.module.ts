import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import {HttpClientModule} from "@angular/common/http";
import { TableDetailsComponent } from './table-details/table-details.component';
import {HashLocationStrategy, LocationStrategy, PathLocationStrategy} from '@angular/common';
import {AddNarachkaCategoriesComponent} from "./add-narachka-categories/add-narachka-categories.component";
import { AddNarachkaProductsComponent } from './add-narachka-products/add-narachka-products.component';
import { AddNarachkaProductKolichinaComponent } from './add-narachka-product-kolichina/add-narachka-product-kolichina.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    TableDetailsComponent,
    AddNarachkaCategoriesComponent,
    AddNarachkaProductsComponent,
    AddNarachkaProductKolichinaComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    { provide: LocationStrategy, useClass: HashLocationStrategy }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
