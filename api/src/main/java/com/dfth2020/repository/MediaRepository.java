package com.dfth2020.repository;

import com.dfth2020.entity.MediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<MediaEntity, String> {
}
