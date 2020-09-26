package com.dfth2020.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "order_item")
public class OrderItemEntity {

    @Id
    private UUID id;

    private UUID orderId;

    public OrderItemEntity() {

    }

    public OrderItemEntity(UUID id, UUID orderId) {
        this.id = id;
        this.orderId = orderId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemEntity orderItemEntity = (OrderItemEntity) o;
        return Objects.equals(id, orderItemEntity.id) &&
                Objects.equals(orderId, orderItemEntity.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId);
    }
}
