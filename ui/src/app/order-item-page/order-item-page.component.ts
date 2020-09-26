import {Component, OnInit} from '@angular/core';
import {OrderItem, OrderItemService} from '../../../generated_src';
import {ActivatedRoute} from '@angular/router';
import {switchMap} from 'rxjs/operators';

@Component({
  selector: 'app-order-item-page',
  templateUrl: './order-item-page.component.html',
  styleUrls: ['./order-item-page.component.css']
})
export class OrderItemPageComponent implements OnInit {

  constructor(private route: ActivatedRoute, private orderItemService: OrderItemService) {
  }

  orderItem: OrderItem;

  ngOnInit(): void {
    this.route.params.pipe(
      switchMap(params => this.orderItemService.getOrderItem(params.orderId, params.orderItemId))
    ).subscribe(orderItem => this.orderItem = orderItem);
  }
}
