package com.dfth2020.mapper;

import com.dfth2020.entity.OrderItemEntity;
import com.dfth2020.server.model.OrderItem;
import com.dfth2020.server.model.ProductionStep;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderItemMapperTest {

    @Test
    public void ensureMapOrderItemMapsEntity() {
        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setId(UUID.fromString("0657a16f-ea32-4d6e-907e-64b5c50f2be1"));
        orderItemEntity.setOrderId(UUID.fromString("0c9a057b-9027-49b1-ba89-d62c5c86b468"));

        ProductionStep productionStep = new ProductionStep();
        List<ProductionStep> productionSteps = Collections.singletonList(productionStep);

        OrderItem orderItem = OrderItemMapper.mapOrderItem(orderItemEntity, productionSteps);

        assertThat(orderItem.getId()).isEqualTo(UUID.fromString("0657a16f-ea32-4d6e-907e-64b5c50f2be1"));
        assertThat(orderItem.getProductionSteps()).isEqualTo(productionSteps);
    }
}
