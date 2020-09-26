package com.dfth2020.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ProductionStep {

    @Id
    private String id;

    private String orderItemId;

    private String stepCode;

    private String title;

    private String description;

    private String status;

    private Integer stepOrder;

    public ProductionStep() {

    }

    public ProductionStep(String id, String orderItemId, String stepCode, String title,
                          String description, String status, Integer stepOrder) {
        this.id = id;
        this.orderItemId = orderItemId;
        this.stepCode = stepCode;
        this.title = title;
        this.description = description;
        this.status = status;
        this.stepOrder = stepOrder;
    }

    public String getId() {
        return id;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public String getStepCode() {
        return stepCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public Integer getStepOrder() {
        return stepOrder;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public void setStepCode(String stepCode) {
        this.stepCode = stepCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStepOrder(Integer stepOrder) {
        this.stepOrder = stepOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductionStep that = (ProductionStep) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(orderItemId, that.orderItemId) &&
                Objects.equals(stepCode, that.stepCode) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(status, that.status) &&
                Objects.equals(stepOrder, that.stepOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderItemId, stepCode, title, description, status, stepOrder);
    }
}
