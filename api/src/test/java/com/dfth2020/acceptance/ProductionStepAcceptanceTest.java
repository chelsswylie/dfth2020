package com.dfth2020.acceptance;

import com.dfth2020.client.api.ProductionStepApi;
import com.dfth2020.client.model.ProductionStep;
import com.dfth2020.client.model.ProductionStepStatus;
import com.dfth2020.client.model.UpdateProductionStep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductionStepAcceptanceTest extends BaseAcceptanceTest{

    private ProductionStepApi productionStepApi;

    @BeforeEach
    public void before() {
        productionStepApi = new ProductionStepApi();
        productionStepApi.setApiClient(getApiClient());
    }

    @Test
    public void ensureGetProductionStepReturns200ForFoundStep() {
        ProductionStep productionStep = productionStepApi.getProductionStep(UUID.fromString("6ac3221e-5d30-4e2b-bb63-52a3020a7ada"));

        assertThat(productionStep).isNotNull();
        assertThat(productionStep.getId()).isEqualTo(UUID.fromString("6ac3221e-5d30-4e2b-bb63-52a3020a7ada"));
    }

    @Test
    public  void ensureGetProductionStepRetruns404ForMissingStep() {
        assertThatThrownBy(() -> {
            productionStepApi.getProductionStep(UUID.randomUUID());
        }).isInstanceOf(HttpClientErrorException.NotFound.class);

    }

    @Test
    public void ensureUpdateProductStepReturns202ForSuccessfulUpdate() {
        UpdateProductionStep updateProductionStep = new UpdateProductionStep();
        updateProductionStep.setStatus(ProductionStepStatus.IN_PROGRESS);

        productionStepApi.updateProductionStep(UUID.fromString("6ac3221e-5d30-4e2b-bb63-52a3020a7ada"), updateProductionStep);

        ProductionStep productionStep = productionStepApi.getProductionStep(UUID.fromString("6ac3221e-5d30-4e2b-bb63-52a3020a7ada"));

        assertThat(productionStep).isNotNull();
        assertThat(productionStep.getStatus()).isEqualTo(ProductionStepStatus.IN_PROGRESS);
    }

    @Test
    public void ensureUpdateProductionStepReturns404ForMissingProductionStep() {
        UpdateProductionStep updateProductionStep = new UpdateProductionStep();
        updateProductionStep.setStatus(ProductionStepStatus.NOT_STARTED);

        assertThatThrownBy(() -> {
            productionStepApi.updateProductionStep(UUID.randomUUID(), updateProductionStep);
        }).isInstanceOf(HttpClientErrorException.NotFound.class);

    }
}
