package com.dfth2020.controller;

import com.dfth2020.entity.OrderEntity;
import com.dfth2020.entity.OrderItemEntity;
import com.dfth2020.entity.ProductionStepEntity;
import com.dfth2020.mapper.OrderItemMapper;
import com.dfth2020.mapper.OrderMapper;
import com.dfth2020.mapper.ProductionStepMapper;
import com.dfth2020.repository.OrderItemRepository;
import com.dfth2020.repository.OrderRepository;
import com.dfth2020.repository.ProductionStepRepository;
import com.dfth2020.server.api.OrderApi;
import com.dfth2020.server.model.Order;
import com.dfth2020.server.model.OrderItem;
import com.dfth2020.server.model.Orders;
import com.dfth2020.server.model.ProductionStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Controller
public class OrderController implements OrderApi {

    private OrderRepository orderRepository;

    private OrderItemRepository orderItemRepository;

    private ProductionStepRepository productionStepRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository, OrderItemRepository orderItemRepository,
                           ProductionStepRepository productionStepRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productionStepRepository = productionStepRepository;
    }

    @Override
    public ResponseEntity<Orders> getOrders() {
        List<OrderEntity> orderEntities = orderRepository.findAll();

        List<Order> orderList = orderEntities.stream().map(orderEntity -> {
           List<OrderItem> orderItems = orderEntity.getOrderItems().stream().map(orderItem -> {
              List<ProductionStep> productionSteps = orderItem.getProductionSteps().stream().map(ProductionStepMapper::mapProductionStep).collect(toList());
              return OrderItemMapper.mapOrderItem(orderItem, productionSteps);
           }).collect(toList());

           return OrderMapper.mapOrder(orderEntity, orderItems);
        }).collect(toList());

        Orders orders = OrderMapper.mapOrders(orderList);

        return ResponseEntity.ok(orders);
    }

    @Override
    public ResponseEntity<OrderItem> getOrderItem(UUID orderId, UUID orderItemId) {
        Optional<OrderItemEntity> orderItemEntity = orderItemRepository.findByIdAndOrderItemId(orderId, orderItemId);

        if (orderItemEntity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<ProductionStepEntity> productionStepEntities = productionStepRepository.findByOrderItemId(orderItemId);
        List<ProductionStep> productionSteps = productionStepEntities.stream().map(ProductionStepMapper::mapProductionStep).collect(toList());
        OrderItem orderItem = OrderItemMapper.mapOrderItem(orderItemEntity.get(), productionSteps);

        return ResponseEntity.ok(orderItem);
    }
}
