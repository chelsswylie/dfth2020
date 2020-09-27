package com.dfth2020.generator;

import com.dfth2020.entity.OrderEntity;
import com.dfth2020.entity.OrderItemEntity;
import com.dfth2020.entity.ProductionStepEntity;
import com.dfth2020.server.model.CreateOrder;
import com.dfth2020.server.model.OrderItem;
import com.dfth2020.server.model.ProductionStepStatus;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderGenerator {

    public static OrderEntity generateOrder(CreateOrder createOrder) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(UUID.randomUUID());

        List<OrderItemEntity> orderItems = IntStream.rangeClosed(1, createOrder.getNumOrderItems())
                        .mapToObj((current) -> generateOrderItem(orderEntity.getId()))
                        .collect(Collectors.toList());
        orderEntity.setOrderItems(orderItems);

        return orderEntity;
    }

    private static OrderItemEntity generateOrderItem(UUID orderId) {
        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setId(UUID.randomUUID());
        orderItemEntity.setOrderId(orderId);
        orderItemEntity.setProductionSteps(generateProductionSteps(orderItemEntity.getId()));
        return orderItemEntity;
    }

    private static List<ProductionStepEntity> generateProductionSteps(UUID orderItemId) {
        return Arrays.asList(
                new ProductionStepEntity(UUID.randomUUID(), orderItemId, "mmc", "Marker Making & Cutting", "Marker Making & Cutting", ProductionStepStatus.NOT_STARTED.toString(), 1, "/assets/steps/6.png"),
                new ProductionStepEntity(UUID.randomUUID(), orderItemId, "prep", "Prep", "Prep", ProductionStepStatus.NOT_STARTED.toString(), 2, "/assets/steps/7.png"),
                new ProductionStepEntity(UUID.randomUUID(), orderItemId, "fp", "Front Panel", "Front Panel", ProductionStepStatus.NOT_STARTED.toString(), 3, "/assets/steps/8.png"),
                new ProductionStepEntity(UUID.randomUUID(), orderItemId, "bp", "Back Panel", "Back Panel", ProductionStepStatus.NOT_STARTED.toString(), 4, "/assets/steps/9.png"),
                new ProductionStepEntity(UUID.randomUUID(), orderItemId, "m", "Marriage", "Marriage", ProductionStepStatus.NOT_STARTED.toString(), 5, "/assets/steps/10.png"),
                new ProductionStepEntity(UUID.randomUUID(), orderItemId, "waist", "Waistband", "Waistband", ProductionStepStatus.NOT_STARTED.toString(), 6, "/assets/steps/11.png"),
                new ProductionStepEntity(UUID.randomUUID(), orderItemId, "finish", "Finishing", "Finishing", ProductionStepStatus.NOT_STARTED.toString(), 7, "/assets/steps/dfth2020pic4.png"),
                new ProductionStepEntity(UUID.randomUUID(), orderItemId, "qc", "Quality Control", "Quality Control", ProductionStepStatus.NOT_STARTED.toString(), 8, "/assets/steps/pic5.png"),
                new ProductionStepEntity(UUID.randomUUID(), orderItemId, "ff", "Fulfillment", "Fulfillment", ProductionStepStatus.NOT_STARTED.toString(), 9, null)
        );
    }
}
