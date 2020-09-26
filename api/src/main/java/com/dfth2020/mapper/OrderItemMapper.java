package com.dfth2020.mapper;

import com.dfth2020.entity.OrderItemEntity;
import com.dfth2020.server.model.OrderItem;

public class OrderItemMapper {
    public static OrderItem mapOrderItem(OrderItemEntity orderItemEntity) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemEntity.getId());

        return orderItem;
    }
}
