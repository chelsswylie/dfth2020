package com.dfth2020.repository;

import com.dfth2020.entity.ProductionStepEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionStepRepository extends JpaRepository<ProductionStepEntity, String> {
}
