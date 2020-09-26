import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule, ExtraOptions } from '@angular/router';
import { ProductionProcessComponent } from './production-process/production-process.component';
import { OrderItemPageComponent } from './order-item-page/order-item-page.component';
import { OrdersPageComponent } from './orders-page/orders-page.component';

const routerOptions: ExtraOptions = {
  scrollPositionRestoration: 'enabled',
  anchorScrolling: 'enabled',
  scrollOffset: [0, 64],
};

const routes: Routes = [
  { path: '', component: ProductionProcessComponent },
  { path: 'orderItemPage', component: OrderItemPageComponent },
  { path: 'productionProcess', component: ProductionProcessComponent },
  { path: 'ordersPage', component: OrdersPageComponent },
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes, routerOptions)],
  exports: [CommonModule, RouterModule],
})
export class AppRoutingModule {}
