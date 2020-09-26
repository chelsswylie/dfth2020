package com.dfth2020.mapper;

import com.dfth2020.entity.ProductionStepEntity;
import com.dfth2020.server.model.ProductionStep;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductionStepMapperTest {

    @Test
    public void ensureMapProductionStepMapsFromEntity() {
        ProductionStepEntity productionStepEntity = new ProductionStepEntity();
        productionStepEntity.setId(UUID.fromString("0657a16f-ea32-4d6e-907e-64b5c50f2be1"));
        productionStepEntity.setTitle("title");
        productionStepEntity.setDescription("description");
        productionStepEntity.setStatus("not_started");
        productionStepEntity.setOrderItemId(UUID.fromString("0c9a057b-9027-49b1-ba89-d62c5c86b468"));
        productionStepEntity.setStepCode("step-code");
        productionStepEntity.setStepOrder(1);

        ProductionStep productionStep = ProductionStepMapper.mapProductionStep(productionStepEntity);

        assertThat(productionStep.getId()).isEqualTo(UUID.fromString("0657a16f-ea32-4d6e-907e-64b5c50f2be1"));
        assertThat(productionStep.getTitle()).isEqualTo("title");
        assertThat(productionStep.getDescription()).isEqualTo("description");
        assertThat(productionStep.getStatus()).isEqualTo(ProductionStep.StatusEnum.NOT_STARTED);
        assertThat(productionStep.getOrder()).isEqualTo("1");
    }
}
