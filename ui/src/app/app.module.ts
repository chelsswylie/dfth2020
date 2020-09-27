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
import {HttpClientModule} from '@angular/common/http';
import {BASE_PATH} from '../../generated_src';
import {OrderPageComponent} from './order-page/order-page.component';
import {StatusToStringPipe} from './status-to-string.pipe';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";

@NgModule({
  declarations: [
    AppComponent,
    OrdersPageComponent,
    OrderItemPageComponent,
    OrderPageComponent,
    StatusToStringPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatButtonModule,
    MatStepperModule,
    MatExpansionModule,
    MatListModule,
    MatToolbarModule,
  ],
  providers: [
    { provide: BASE_PATH, useValue: 'http://localhost:4200/api' }
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
