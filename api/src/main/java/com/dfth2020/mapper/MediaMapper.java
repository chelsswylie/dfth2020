package com.dfth2020.mapper;

import com.dfth2020.entity.MediaEntity;

public class MediaMapper {
    public static String mapMedia(MediaEntity mediaEntity) {
        return mediaEntity.getMediaUrl();
    }
}
