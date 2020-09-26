import { Component, OnInit } from '@angular/core';
import {Orders, OrderService} from '../../../generated_src';

@Component({
  selector: 'app-orders-page',
  templateUrl: './orders-page.component.html',
  styleUrls: ['./orders-page.component.css']
})
export class OrdersPageComponent implements OnInit {

  orders: Orders;

  constructor(private orderService: OrderService) {
  }

  ngOnInit(): void {
    this.orderService.getOrders().subscribe(orders => {
      this.orders = orders;
    });
  }
}
