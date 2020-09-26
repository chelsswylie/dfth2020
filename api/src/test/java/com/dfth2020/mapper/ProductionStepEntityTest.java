package com.dfth2020.mapper;

import com.dfth2020.entity.ProductionStepEntity;
import com.dfth2020.server.model.ProductionStep;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductionStepEntityTest {

    @Test
    public void ensureMapProductionStepMapsFromEntity() {
        ProductionStepEntity productionStepEntity = new ProductionStepEntity();
        productionStepEntity.setId("id");
        productionStepEntity.setTitle("title");
        productionStepEntity.setDescription("description");
        productionStepEntity.setStatus("not_started");
        productionStepEntity.setOrderItemId("order-item-id");
        productionStepEntity.setStepCode("step-code");
        productionStepEntity.setStepOrder(1);

        ProductionStep productionStep = ProductionStepMapper.mapProductionStep(productionStepEntity);

        assertThat(productionStep.getId()).isEqualTo("id");
        assertThat(productionStep.getTitle()).isEqualTo("title");
        assertThat(productionStep.getDescription()).isEqualTo("description");
        assertThat(productionStep.getStatus()).isEqualTo(ProductionStep.StatusEnum.NOT_STARTED);
        assertThat(productionStep.getOrder()).isEqualTo("1");
    }
}
