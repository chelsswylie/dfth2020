package com.dfth2020.mapper;

import com.dfth2020.entity.MediaEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MediaMapperTest {

    @Test
    public void ensureMapMediaMapsFromEntity() {
        MediaEntity mediaEntity = new MediaEntity();
        mediaEntity.setId("id");
        mediaEntity.setMediaUrl("http://cdn.media.com/test.png");
        mediaEntity.setProductionStepId("production-step-id");

        String media = MediaMapper.mapMedia(mediaEntity);

        assertThat(media).isEqualTo("http://cdn.media.com/test.png");
    }
}
