package com.dfth2020.mapper;

import com.dfth2020.entity.MediaEntity;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class MediaMapperTest {

    @Test
    public void ensureMapMediaMapsFromEntity() {
        MediaEntity mediaEntity = new MediaEntity();
        mediaEntity.setId(UUID.fromString("0657a16f-ea32-4d6e-907e-64b5c50f2be1"));
        mediaEntity.setMediaUrl("http://cdn.media.com/test.png");
        mediaEntity.setProductionStepId(UUID.fromString("0c9a057b-9027-49b1-ba89-d62c5c86b468"));

        String media = MediaMapper.mapMedia(mediaEntity);

        assertThat(media).isEqualTo("http://cdn.media.com/test.png");
    }
}
