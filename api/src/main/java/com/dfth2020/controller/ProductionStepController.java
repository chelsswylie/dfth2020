package com.dfth2020.controller;

import com.dfth2020.entity.ProductionStepEntity;
import com.dfth2020.repository.OrderItemRepository;
import com.dfth2020.repository.OrderRepository;
import com.dfth2020.repository.ProductionStepRepository;
import com.dfth2020.server.api.ProductionStepApi;
import com.dfth2020.server.model.UpdateProductionStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.UUID;

@Controller
public class ProductionStepController implements ProductionStepApi {

    private ProductionStepRepository productionStepRepository;

    @Autowired
    public ProductionStepController(ProductionStepRepository productionStepRepository) {
        this.productionStepRepository = productionStepRepository;
    }

    @Override
    public ResponseEntity<Void> updateProductionStep(UUID productionStepId, UpdateProductionStep updateProductionStep) {
        Optional<ProductionStepEntity> productionStepEntity = productionStepRepository.findById(productionStepId);

        if(productionStepEntity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        String statusChange = productionStepEntity.get().getStatus();
        productionStepEntity.get().setStatus(statusChange);

        return ResponseEntity.accepted().build();
    }
}
