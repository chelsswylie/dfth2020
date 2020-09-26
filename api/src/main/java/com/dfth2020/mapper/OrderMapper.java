package com.dfth2020.mapper;

import com.dfth2020.entity.OrderEntity;
import com.dfth2020.server.model.Order;
import com.dfth2020.server.model.OrderItem;
import com.dfth2020.server.model.Orders;

import java.util.List;

public class OrderMapper {
    public static Orders mapOrders(List<Order> ordersList) {
        Orders orders = new Orders();
        orders.setOrders(ordersList);

        return orders;
    }

    public static Order mapOrder(OrderEntity orderEntity, List<OrderItem> orderItems) {
        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setOrderItems(orderItems);

        return order;
    }
}
