package com.dfth2020.controller;

import com.dfth2020.entity.ProductionStepEntity;
import com.dfth2020.mapper.ProductionStepMapper;
import com.dfth2020.repository.OrderItemRepository;
import com.dfth2020.repository.OrderRepository;
import com.dfth2020.repository.ProductionStepRepository;
import com.dfth2020.server.api.ProductionStepApi;
import com.dfth2020.server.model.ProductionStep;
import com.dfth2020.server.model.ProductionStepStatus;
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
    public ResponseEntity<ProductionStep> getProductionStep(UUID productionStepId) {
        Optional<ProductionStepEntity> productionStepEntity = productionStepRepository.findById(productionStepId);

        if (productionStepEntity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ProductionStep productionStep = ProductionStepMapper.mapProductionStep(productionStepEntity.get());

        return ResponseEntity.ok(productionStep);
    }

    @Override
    public ResponseEntity<Void> updateProductionStep(UUID productionStepId, UpdateProductionStep updateProductionStep) {
        Optional<ProductionStepEntity> maybeProductionStepEntity = productionStepRepository.findById(productionStepId);

        if (maybeProductionStepEntity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ProductionStepEntity productionStepEntity = maybeProductionStepEntity.get();
        productionStepEntity.setStatus(updateProductionStep.getStatus().toString());
        productionStepRepository.save(productionStepEntity);

        return ResponseEntity.accepted().build();
    }
}
