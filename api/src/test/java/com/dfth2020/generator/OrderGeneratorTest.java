package com.dfth2020.generator;

import com.dfth2020.entity.OrderEntity;
import com.dfth2020.entity.OrderItemEntity;
import com.dfth2020.entity.ProductionStepEntity;
import com.dfth2020.server.model.CreateOrder;
import com.dfth2020.server.model.ProductionStepStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderGeneratorTest {

    @Test
    public void ensureGenerateOrderGeneratesAnOrder() {
        CreateOrder createOrder = new CreateOrder();
        createOrder.setNumOrderItems(1);

        OrderEntity orderEntity = OrderGenerator.generateOrder(createOrder);

        assertThat(orderEntity.getId().toString()).isInstanceOf(String.class);
        assertThat(orderEntity.getOrderItems().size()).isEqualTo(1);

        OrderItemEntity orderItemEntity = orderEntity.getOrderItems().get(0);
        assertThat(orderItemEntity.getId().toString()).isInstanceOf(String.class);
        assertThat(orderItemEntity.getOrderId()).isEqualTo(orderEntity.getId());
        assertThat(orderItemEntity.getProductionSteps().size()).isEqualTo(9);
    }

    @Test
    public void ensureGenerateOrderGeneratesAnOrderWithAllProductionSteps() {
        CreateOrder createOrder = new CreateOrder();
        createOrder.setNumOrderItems(1);

        OrderEntity orderEntity = OrderGenerator.generateOrder(createOrder);
        OrderItemEntity orderItemEntity = orderEntity.getOrderItems().get(0);
        List<ProductionStepEntity> productionStepEntities = orderItemEntity.getProductionSteps();

        ProductionStepEntity mmcStep = productionStepEntities.get(0);
        assertThat(mmcStep.getId().toString()).isInstanceOf(String.class);
        assertThat(mmcStep.getOrderItemId()).isEqualTo(orderItemEntity.getId());
        assertThat(mmcStep.getStepCode()).isEqualTo("mmc");
        assertThat(mmcStep.getTitle()).isEqualTo("Marker Making & Cutting");
        assertThat(mmcStep.getDescription()).isEqualTo("Marker Making & Cutting");
        assertThat(mmcStep.getStatus()).isEqualTo(ProductionStepStatus.NOT_STARTED.toString());
        assertThat(mmcStep.getStepOrder()).isEqualTo(1);

        ProductionStepEntity prepStep = productionStepEntities.get(1);
        assertThat(prepStep.getId().toString()).isInstanceOf(String.class);
        assertThat(prepStep.getOrderItemId()).isEqualTo(orderItemEntity.getId());
        assertThat(prepStep.getStepCode()).isEqualTo("prep");
        assertThat(prepStep.getTitle()).isEqualTo("Prep");
        assertThat(prepStep.getDescription()).isEqualTo("Prep");
        assertThat(prepStep.getStatus()).isEqualTo(ProductionStepStatus.NOT_STARTED.toString());
        assertThat(prepStep.getStepOrder()).isEqualTo(2);

        ProductionStepEntity fpStep = productionStepEntities.get(2);
        assertThat(fpStep.getId().toString()).isInstanceOf(String.class);
        assertThat(fpStep.getOrderItemId()).isEqualTo(orderItemEntity.getId());
        assertThat(fpStep.getStepCode()).isEqualTo("fp");
        assertThat(fpStep.getTitle()).isEqualTo("Front Panel");
        assertThat(fpStep.getDescription()).isEqualTo("Front Panel");
        assertThat(fpStep.getStatus()).isEqualTo(ProductionStepStatus.NOT_STARTED.toString());
        assertThat(fpStep.getStepOrder()).isEqualTo(3);

        ProductionStepEntity bpStep = productionStepEntities.get(3);
        assertThat(bpStep.getId().toString()).isInstanceOf(String.class);
        assertThat(bpStep.getOrderItemId()).isEqualTo(orderItemEntity.getId());
        assertThat(bpStep.getStepCode()).isEqualTo("bp");
        assertThat(bpStep.getTitle()).isEqualTo("Back Panel");
        assertThat(bpStep.getDescription()).isEqualTo("Back Panel");
        assertThat(bpStep.getStatus()).isEqualTo(ProductionStepStatus.NOT_STARTED.toString());
        assertThat(bpStep.getStepOrder()).isEqualTo(4);

        ProductionStepEntity mStep = productionStepEntities.get(4);
        assertThat(mStep.getId().toString()).isInstanceOf(String.class);
        assertThat(mStep.getOrderItemId()).isEqualTo(orderItemEntity.getId());
        assertThat(mStep.getStepCode()).isEqualTo("m");
        assertThat(mStep.getTitle()).isEqualTo("Marriage");
        assertThat(mStep.getDescription()).isEqualTo("Marriage");
        assertThat(mStep.getStatus()).isEqualTo(ProductionStepStatus.NOT_STARTED.toString());
        assertThat(mStep.getStepOrder()).isEqualTo(5);

        ProductionStepEntity waistStep = productionStepEntities.get(5);
        assertThat(waistStep.getId().toString()).isInstanceOf(String.class);
        assertThat(waistStep.getOrderItemId()).isEqualTo(orderItemEntity.getId());
        assertThat(waistStep.getStepCode()).isEqualTo("waist");
        assertThat(waistStep.getTitle()).isEqualTo("Waistband");
        assertThat(waistStep.getDescription()).isEqualTo("Waistband");
        assertThat(waistStep.getStatus()).isEqualTo(ProductionStepStatus.NOT_STARTED.toString());
        assertThat(waistStep.getStepOrder()).isEqualTo(6);

        ProductionStepEntity finishStep = productionStepEntities.get(6);
        assertThat(finishStep.getId().toString()).isInstanceOf(String.class);
        assertThat(finishStep.getOrderItemId()).isEqualTo(orderItemEntity.getId());
        assertThat(finishStep.getStepCode()).isEqualTo("finish");
        assertThat(finishStep.getTitle()).isEqualTo("Finishing");
        assertThat(finishStep.getDescription()).isEqualTo("Finishing");
        assertThat(finishStep.getStatus()).isEqualTo(ProductionStepStatus.NOT_STARTED.toString());
        assertThat(finishStep.getStepOrder()).isEqualTo(7);

        ProductionStepEntity qcStep = productionStepEntities.get(7);
        assertThat(qcStep.getId().toString()).isInstanceOf(String.class);
        assertThat(qcStep.getOrderItemId()).isEqualTo(orderItemEntity.getId());
        assertThat(qcStep.getStepCode()).isEqualTo("qc");
        assertThat(qcStep.getTitle()).isEqualTo("Quality Control");
        assertThat(qcStep.getDescription()).isEqualTo("Quality Control");
        assertThat(qcStep.getStatus()).isEqualTo(ProductionStepStatus.NOT_STARTED.toString());
        assertThat(qcStep.getStepOrder()).isEqualTo(8);

        ProductionStepEntity ffStep = productionStepEntities.get(8);
        assertThat(ffStep.getId().toString()).isInstanceOf(String.class);
        assertThat(ffStep.getOrderItemId()).isEqualTo(orderItemEntity.getId());
        assertThat(ffStep.getStepCode()).isEqualTo("ff");
        assertThat(ffStep.getTitle()).isEqualTo("Fulfillment");
        assertThat(ffStep.getDescription()).isEqualTo("Fulfillment");
        assertThat(ffStep.getStatus()).isEqualTo(ProductionStepStatus.NOT_STARTED.toString());
        assertThat(ffStep.getStepOrder()).isEqualTo(9);
    }

    @Test
    public void ensureGenerateOrderGeneratesAnOrderWithMultipleOrderItems() {
        CreateOrder createOrder = new CreateOrder();
        createOrder.setNumOrderItems(2);

        OrderEntity orderEntity = OrderGenerator.generateOrder(createOrder);

        assertThat(orderEntity.getOrderItems().size()).isEqualTo(2);
    }
}
