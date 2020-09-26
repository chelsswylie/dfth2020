package com.dfth2020.acceptance;

import com.dfth2020.client.api.OrderItemApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderAcceptanceTest extends BaseAcceptanceTest {

    private OrderItemApi orderItemApi;

    @BeforeEach
    public void before() {
        orderItemApi = new OrderItemApi();
        orderItemApi.setApiClient(getApiClient());
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
