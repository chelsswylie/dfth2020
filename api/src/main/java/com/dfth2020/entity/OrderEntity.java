package com.dfth2020.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "order")
public class OrderEntity {

    @Id
    private UUID id;

    public OrderEntity() {

    }

    public OrderEntity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity orderEntity = (OrderEntity) o;
        return Objects.equals(id, orderEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
