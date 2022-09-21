import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {TableDetailsComponent} from "./table-details/table-details.component";
import {AddNarachkaCategoriesComponent} from "./add-narachka-categories/add-narachka-categories.component";
import {AddNarachkaProductsComponent} from "./add-narachka-products/add-narachka-products.component";
import {
  AddNarachkaProductKolichinaComponent
} from "./add-narachka-product-kolichina/add-narachka-product-kolichina.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'tables/:id', component: TableDetailsComponent},
  {path: 'tables/:id/categories', component: AddNarachkaCategoriesComponent},
  {path: 'tables/:id/categories/:categoryId', component: AddNarachkaProductsComponent},
  {path: 'tables/:id/categories/:categoryId/:productId', component: AddNarachkaProductKolichinaComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
