import { Component, OnInit } from '@angular/core';
import { Order, OrderService } from "../../../generated_src";

@Component({
  selector: 'app-orders-page',
  templateUrl: './orders-page.component.html',
  styleUrls: ['./orders-page.component.css']
})
export class OrdersPageComponent implements OnInit {

  constructor(private orderService: OrderService) { }

  order: Order;

  ngOnInit(): void {
    this.orderService.orderOrderIdGet('id','body', true)
      .subscribe(order => {
        this.order = order;
      });
  }

}
