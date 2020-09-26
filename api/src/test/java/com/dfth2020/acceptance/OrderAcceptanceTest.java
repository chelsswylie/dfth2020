package com.dfth2020.acceptance;

import com.dfth2020.client.api.OrderApi;
import com.dfth2020.client.api.OrderItemApi;
import com.dfth2020.client.model.Order;
import com.dfth2020.client.model.OrderItem;
import com.dfth2020.client.model.Orders;
import com.dfth2020.client.model.ProductionStep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderAcceptanceTest extends BaseAcceptanceTest {

    private OrderApi orderApi;

    private OrderItemApi orderItemApi;

    @BeforeEach
    public void before() {
        orderApi = new OrderApi();
        orderApi.setApiClient(getApiClient());

        orderItemApi = new OrderItemApi();
        orderItemApi.setApiClient(getApiClient());
    }

    @Test
    public void ensureGetOrderReturns200() {
        Orders orders = orderApi.getOrders();

        assertThat(orders.getOrders()).isNotNull();

        List<OrderItem> orderItems = orders.getOrders().get(0).getOrderItems();
        assertThat(orderItems).hasAtLeastOneElementOfType(OrderItem.class);

        List<ProductionStep> productionSteps = orderItems.get(0).getProductionSteps();
        assertThat(productionSteps).hasAtLeastOneElementOfType(ProductionStep.class);
    }

    @Test
    public void ensureGetOrderReturns200ForFoundOrder() {
        Order order = orderApi.getOrder(UUID.fromString("ddfc229c-3c4f-4c5f-a59f-d7a1d8da8675"));

        assertThat(order).isNotNull();
        assertThat(order.getId()).isEqualTo(UUID.fromString("ddfc229c-3c4f-4c5f-a59f-d7a1d8da8675"));
    }

    @Test
    public void ensureGetOrderItemReturns200ForFoundOrderItem() {
        OrderItem orderItem = orderItemApi.getOrderItem(UUID.fromString("ddfc229c-3c4f-4c5f-a59f-d7a1d8da8675"), UUID.fromString("41b73992-3eac-4583-b11e-1a8b1fcad370"));

        assertThat(orderItem).isNotNull();
        assertThat(orderItem.getId()).isEqualTo(UUID.fromString("41b73992-3eac-4583-b11e-1a8b1fcad370"));
        assertThat(orderItem.getProductionSteps().get(0).getOrder()).isEqualTo(new BigDecimal(1));
    }

    @Test
    public void ensureGetOrderItemsReturns404ForMissingOrder() {
        assertThatThrownBy(() -> {
            orderItemApi.getOrderItem(UUID.randomUUID(), UUID.randomUUID());
        }).isInstanceOf(HttpClientErrorException.NotFound.class);
    }

    @Test
    public void ensureGetOrderItemsReturns404ForMissingOrderItem() {
        assertThatThrownBy(() -> {
            orderItemApi.getOrderItem(UUID.fromString("ddfc229c-3c4f-4c5f-a59f-d7a1d8da8675"), UUID.randomUUID());
        }).isInstanceOf(HttpClientErrorException.NotFound.class);
    }
}
