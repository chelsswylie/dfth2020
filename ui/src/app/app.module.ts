import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {MatStepperModule} from '@angular/material/stepper';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatListModule} from '@angular/material/list';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {OrdersPageComponent} from './orders-page/orders-page.component';
import {OrderItemPageComponent} from './order-item-page/order-item-page.component';
import {NavBarComponent} from './nav-bar/nav-bar.component';
import {HttpClientModule} from '@angular/common/http';
import {BASE_PATH} from '../../generated_src';
import { OrderPageComponent } from './order-page/order-page.component';
import { HomeComponent } from './home/home.component';
import { StatusToStringPipe } from './status-to-string.pipe';

@NgModule({
  declarations: [
    AppComponent,
    OrdersPageComponent,
    OrderItemPageComponent,
    NavBarComponent,
    OrderPageComponent,
    HomeComponent,
    StatusToStringPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatStepperModule,
    MatExpansionModule,
    MatListModule,
  ],
  providers: [
    { provide: BASE_PATH, useValue: 'http://localhost:4200/api' }
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
