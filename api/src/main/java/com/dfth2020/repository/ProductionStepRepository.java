package com.dfth2020.repository;

import com.dfth2020.entity.ProductionStepEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductionStepRepository extends JpaRepository<ProductionStepEntity, String> {

    List<ProductionStepEntity> findByOrderItemId(UUID orderItemId);
}
