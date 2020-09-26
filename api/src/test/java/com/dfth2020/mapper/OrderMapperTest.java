package com.dfth2020.mapper;

import com.dfth2020.entity.OrderEntity;
import com.dfth2020.server.model.Order;
import com.dfth2020.server.model.OrderItem;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderMapperTest {

    @Test
    public void ensureMapOrderMapsFromEntity() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(UUID.fromString("0657a16f-ea32-4d6e-907e-64b5c50f2be1"));

        List<OrderItem> orderItems = Collections.singletonList(new OrderItem());

        Order order = OrderMapper.mapOrder(orderEntity, orderItems);

        assertThat(order.getId()).isEqualTo(UUID.fromString("0657a16f-ea32-4d6e-907e-64b5c50f2be1"));
        assertThat(order.getOrderItems()).isEqualTo(orderItems);
    }
}
