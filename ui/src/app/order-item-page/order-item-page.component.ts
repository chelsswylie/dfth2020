import { Component, OnInit } from '@angular/core';
import { OrderItem, OrderItemService } from "../../../generated_src";

@Component({
  selector: 'app-order-item-page',
  templateUrl: './order-item-page.component.html',
  styleUrls: ['./order-item-page.component.css']
})
export class OrderItemPageComponent implements OnInit {

  constructor(private orderItemService: OrderItemService) { }

  orderItem: OrderItem;

  ngOnInit(): void {
    this.orderItemService.orderOrderIdItemOrderItemIdGet('id', 'id')
      .subscribe( orderItem => {
        this.orderItem = orderItem;
      });
  }

}
