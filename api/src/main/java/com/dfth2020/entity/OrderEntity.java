package com.dfth2020.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "customer_order")
public class OrderEntity {

    @Id
    private UUID id;

    @OneToMany(mappedBy = "orderId")
    private List<OrderItemEntity> orderItems;

    public OrderEntity() {

    }

    public OrderEntity(UUID id, List<OrderItemEntity> orderItems) {
        this.id = id;
        this.orderItems = orderItems;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(orderItems, that.orderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderItems);
    }
}
