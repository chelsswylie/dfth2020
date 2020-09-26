package com.dfth2020.mapper;

import com.dfth2020.entity.OrderItemEntity;
import com.dfth2020.server.model.OrderItem;
import com.dfth2020.server.model.ProductionStep;

import java.util.List;

public class OrderItemMapper {
    public static OrderItem mapOrderItem(OrderItemEntity orderItemEntity, List<ProductionStep> productionSteps) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemEntity.getId());
        orderItem.setProductionSteps(productionSteps);

        return orderItem;
    }
}
