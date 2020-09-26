package com.dfth2020.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Media {

    @Id
    private String id;

    private String productionStepId;

    private String mediaUrl;

    public Media() {

    }

    public Media(String id, String productionStepId, String mediaUrl) {
        this.id = id;
        this.productionStepId = productionStepId;
        this.mediaUrl = mediaUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductionStepId() {
        return productionStepId;
    }

    public void setProductionStepId(String productionStepId) {
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
        Media media = (Media) o;
        return Objects.equals(id, media.id) &&
                Objects.equals(productionStepId, media.productionStepId) &&
                Objects.equals(mediaUrl, media.mediaUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productionStepId, mediaUrl);
    }
}
