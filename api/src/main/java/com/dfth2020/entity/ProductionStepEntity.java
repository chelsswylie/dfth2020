package com.dfth2020.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "production_step")
public class ProductionStepEntity {

    @Id
    private UUID id;

    private UUID orderItemId;

    private String stepCode;

    private String title;

    private String description;

    private String status;

    private Integer stepOrder;

    private String mediaUrl;

    public ProductionStepEntity() {

    }

    public ProductionStepEntity(UUID id, UUID orderItemId, String stepCode, String title, String description,
                                String status, Integer stepOrder, String mediaUrl) {
        this.id = id;
        this.orderItemId = orderItemId;
        this.stepCode = stepCode;
        this.title = title;
        this.description = description;
        this.status = status;
        this.stepOrder = stepOrder;
        this.mediaUrl = mediaUrl;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(UUID orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getStepCode() {
        return stepCode;
    }

    public void setStepCode(String stepCode) {
        this.stepCode = stepCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStepOrder() {
        return stepOrder;
    }

    public void setStepOrder(Integer stepOrder) {
        this.stepOrder = stepOrder;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductionStepEntity that = (ProductionStepEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(orderItemId, that.orderItemId) &&
                Objects.equals(stepCode, that.stepCode) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(status, that.status) &&
                Objects.equals(stepOrder, that.stepOrder) &&
                Objects.equals(mediaUrl, that.mediaUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderItemId, stepCode, title, description, status, stepOrder, mediaUrl);
    }
}
