package com.dfth2020.controller;

import com.dfth2020.entity.OrderItemEntity;
import com.dfth2020.entity.ProductionStepEntity;
import com.dfth2020.mapper.OrderItemMapper;
import com.dfth2020.mapper.ProductionStepMapper;
import com.dfth2020.repository.OrderItemRepository;
import com.dfth2020.repository.ProductionStepRepository;
import com.dfth2020.server.api.OrderApi;
import com.dfth2020.server.model.OrderItem;
import com.dfth2020.server.model.ProductionStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class OrderController implements OrderApi {

    private OrderItemRepository orderItemRepository;

    private ProductionStepRepository productionStepRepository;

    @Autowired
    public OrderController(OrderItemRepository orderItemRepository, ProductionStepRepository productionStepRepository) {
        this.orderItemRepository = orderItemRepository;
        this.productionStepRepository = productionStepRepository;
    }

    @Override
    public ResponseEntity<OrderItem> getOrderItem(UUID orderId, UUID orderItemId) {
        Optional<OrderItemEntity> orderItemEntity = orderItemRepository.findByIdAndOrderItemId(orderId, orderItemId);

        if (orderItemEntity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<ProductionStepEntity> productionStepEntities = productionStepRepository.findByOrderItemId(orderItemId);
        List<ProductionStep> productionSteps = productionStepEntities.stream().map(ProductionStepMapper::mapProductionStep).collect(Collectors.toList());
        OrderItem orderItem = OrderItemMapper.mapOrderItem(orderItemEntity.get(), productionSteps);

        return ResponseEntity.ok(orderItem);
    }
}
