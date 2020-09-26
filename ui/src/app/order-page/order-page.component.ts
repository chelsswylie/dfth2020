import {Component, OnInit} from '@angular/core';
import {Order, OrderService} from '../../../generated_src';
import {switchMap} from 'rxjs/operators';
import {ActivatedRoute, Route} from '@angular/router';

@Component({
  selector: 'app-order-page',
  templateUrl: './order-page.component.html',
  styleUrls: ['./order-page.component.css']
})
export class OrderPageComponent implements OnInit {

  constructor(private route: ActivatedRoute, private orderService: OrderService) { }

  order: Order;

  ngOnInit(): void {
    this.route.params.pipe(
      switchMap(params => this.orderService.getOrder(params.orderId))
    ).subscribe(order => this.order = order);
  }
}
