import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule, ExtraOptions } from '@angular/router';
import { ProductionProcessComponent } from './production-process/production-process.component';
import { OrderItemPageComponent } from './order-item-page/order-item-page.component';
import { OrdersPageComponent } from './orders-page/orders-page.component';
import { OrderPageComponent } from './order-page/order-page.component';
import { HomeComponent } from './home/home.component';

const routerOptions: ExtraOptions = {
  scrollPositionRestoration: 'enabled',
  anchorScrolling: 'enabled',
  scrollOffset: [0, 64],
};

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'order', component: OrdersPageComponent },
  { path: 'order/:orderId', component: OrderPageComponent },
  {
    path: 'order/:orderId/item/:orderItemId',
    component: OrderItemPageComponent,
  },
  { path: 'production-process', component: ProductionProcessComponent },
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes, routerOptions)],
  exports: [CommonModule, RouterModule],
})
export class AppRoutingModule {}
