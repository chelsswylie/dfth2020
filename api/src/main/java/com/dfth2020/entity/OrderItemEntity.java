package com.dfth2020.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "order_item")
public class OrderItemEntity {

    @Id
    private UUID id;

    private UUID orderId;

    @OneToMany(mappedBy = "orderItemId", cascade = {CascadeType.ALL})
    private List<ProductionStepEntity> productionSteps;

    public OrderItemEntity() {

    }

    public OrderItemEntity(UUID id, UUID orderId, List<ProductionStepEntity> productionSteps) {
        this.id = id;
        this.orderId = orderId;
        this.productionSteps = productionSteps;
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

    public List<ProductionStepEntity> getProductionSteps() {
        return productionSteps;
    }

    public void setProductionSteps(List<ProductionStepEntity> productionSteps) {
        this.productionSteps = productionSteps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemEntity that = (OrderItemEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(productionSteps, that.productionSteps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, productionSteps);
    }
}
