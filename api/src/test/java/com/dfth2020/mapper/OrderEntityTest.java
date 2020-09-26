package com.dfth2020.mapper;

import com.dfth2020.entity.OrderEntity;
import com.dfth2020.server.model.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderEntityTest {

    @Test
    public void ensureMapOrderMapsFromEntity() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId("id");

        Order order = OrderMapper.mapOrder(orderEntity);

        assertThat(order.getId()).isEqualTo("id");
    }
}
