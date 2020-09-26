package com.dfth2020.acceptance;

import com.dfth2020.client.api.ProductionStepApi;
import com.dfth2020.client.model.ProductionStep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductionStepAcceptanceTest extends BaseAcceptanceTest{

    private ProductionStepApi productionStepApi;

    @BeforeEach
    public void before() {
        productionStepApi = new ProductionStepApi();
        productionStepApi.setApiClient(getApiClient());
    }

    @Test
    public void ensureUpdateProductStepReturns202ForSuccessfulUpdate() {

    }

    @Test
    public void ensureUpdateProductionStepReturns404ForUnsuccessfulUpdate() {

    }
}
