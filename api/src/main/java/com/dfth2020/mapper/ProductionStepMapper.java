package com.dfth2020.mapper;

import com.dfth2020.entity.ProductionStepEntity;
import com.dfth2020.server.model.ProductionStep;

import java.math.BigDecimal;

public class ProductionStepMapper {
    public static ProductionStep mapProductionStep(ProductionStepEntity productionStepEntity) {
        ProductionStep productionStep = new ProductionStep();
        productionStep.setId(productionStepEntity.getId());
        productionStep.setTitle(productionStepEntity.getTitle());
        productionStep.setDescription(productionStepEntity.getDescription());
        productionStep.setStepCode(productionStepEntity.getStepCode());
        productionStep.setOrder(new BigDecimal(productionStepEntity.getStepOrder()));
        productionStep.setStatus(ProductionStep.StatusEnum.fromValue(productionStepEntity.getStatus()));

        return productionStep;
    }
}
