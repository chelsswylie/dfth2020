package com.dfth2020.mapper;

import com.dfth2020.entity.OrderEntity;
import com.dfth2020.server.model.Order;

public class OrderMapper {

    public static Order mapOrder(OrderEntity orderEntity) {
        Order order = new Order();
        order.setId(orderEntity.getId());

        return order;
    }
}
