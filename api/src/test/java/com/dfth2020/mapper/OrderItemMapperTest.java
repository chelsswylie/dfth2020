package com.dfth2020.mapper;

import com.dfth2020.entity.OrderItemEntity;
import com.dfth2020.server.model.OrderItem;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderItemMapperTest {

    @Test
    public void ensureMapOrderItemMapsEntity() {
        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setId("id");
        orderItemEntity.setOrderId("orderId");

        OrderItem orderItem = OrderItemMapper.mapOrderItem(orderItemEntity);

        assertThat(orderItem.getId()).isEqualTo("id");
    }
}
