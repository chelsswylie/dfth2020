package com.dfth2020.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "media")
public class MediaEntity {

    @Id
    private UUID id;

    private UUID productionStepId;

    private String mediaUrl;

    public MediaEntity() {

    }

    public MediaEntity(UUID id, UUID productionStepId, String mediaUrl) {
        this.id = id;
        this.productionStepId = productionStepId;
        this.mediaUrl = mediaUrl;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getProductionStepId() {
        return productionStepId;
    }

    public void setProductionStepId(UUID productionStepId) {
        this.productionStepId = productionStepId;
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
        MediaEntity mediaEntity = (MediaEntity) o;
        return Objects.equals(id, mediaEntity.id) &&
                Objects.equals(productionStepId, mediaEntity.productionStepId) &&
                Objects.equals(mediaUrl, mediaEntity.mediaUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productionStepId, mediaUrl);
    }
}
