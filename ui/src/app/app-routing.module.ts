import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ExtraOptions, RouterModule, Routes} from '@angular/router';
import {OrderItemPageComponent} from './order-item-page/order-item-page.component';
import {OrdersPageComponent} from './orders-page/orders-page.component';
import {OrderPageComponent} from './order-page/order-page.component';

const routerOptions: ExtraOptions = {
  scrollPositionRestoration: 'enabled',
  anchorScrolling: 'enabled',
  scrollOffset: [0, 64],
};

const routes: Routes = [
  { path: '', redirectTo: 'order', pathMatch: 'full' },
  { path: 'order', component: OrdersPageComponent },
  { path: 'order/:orderId', component: OrderPageComponent },
  { path: 'order/:orderId/item/:orderItemId', component: OrderItemPageComponent },
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes, routerOptions)],
  exports: [CommonModule, RouterModule],
})
export class AppRoutingModule {}
