package com.dfth2020.mapper;

import com.dfth2020.entity.OrderEntity;
import com.dfth2020.server.model.Order;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderEntityTest {

    @Test
    public void ensureMapOrderMapsFromEntity() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(UUID.fromString("0657a16f-ea32-4d6e-907e-64b5c50f2be1"));

        Order order = OrderMapper.mapOrder(orderEntity, orderItems);

        assertThat(order.getId()).isEqualTo(UUID.fromString("0657a16f-ea32-4d6e-907e-64b5c50f2be1"));
    }
}
