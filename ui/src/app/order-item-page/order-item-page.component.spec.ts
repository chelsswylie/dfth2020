import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderItemPageComponent } from './order-item-page.component';

describe('OrderItemPageComponent', () => {
  let component: OrderItemPageComponent;
  let fixture: ComponentFixture<OrderItemPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderItemPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderItemPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
