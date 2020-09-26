package com.dfth2020.acceptance;

import com.dfth2020.client.api.OrderItemApi;
import com.dfth2020.client.model.OrderItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderAcceptanceTest extends BaseAcceptanceTest {

    private OrderItemApi orderItemApi;

    @BeforeEach
    public void before() {
        orderItemApi = new OrderItemApi();
        orderItemApi.setApiClient(getApiClient());
    }

    @Test
    public void ensureGetOrderItemReturns200ForFoundOrderItem() {
        OrderItem orderItem = orderItemApi.orderOrderIdItemOrderItemIdGet(UUID.fromString("ddfc229c-3c4f-4c5f-a59f-d7a1d8da8675"), UUID.fromString("41b73992-3eac-4583-b11e-1a8b1fcad370"));

        assertThat(orderItem).isNotNull();
    }

    @Test
    public void ensureGetOrderItemsReturns404ForMissingOrder() {
        assertThatThrownBy(() -> {
            orderItemApi.orderOrderIdItemOrderItemIdGet(UUID.randomUUID(), UUID.randomUUID());
        }).isInstanceOf(HttpClientErrorException.NotFound.class);
    }

    @Test
    public void ensureGetOrderItemsReturns404ForMissingOrderItem() {
        assertThatThrownBy(() -> {
            orderItemApi.orderOrderIdItemOrderItemIdGet(UUID.fromString("ddfc229c-3c4f-4c5f-a59f-d7a1d8da8675"), UUID.randomUUID());
        }).isInstanceOf(HttpClientErrorException.NotFound.class);
    }
}
