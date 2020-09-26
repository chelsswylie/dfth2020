package com.dfth2020.controller;

import com.dfth2020.entity.OrderEntity;
import com.dfth2020.entity.OrderItemEntity;
import com.dfth2020.entity.ProductionStepEntity;
import com.dfth2020.generator.OrderGenerator;
import com.dfth2020.mapper.OrderItemMapper;
import com.dfth2020.mapper.OrderMapper;
import com.dfth2020.mapper.ProductionStepMapper;
import com.dfth2020.repository.OrderItemRepository;
import com.dfth2020.repository.OrderRepository;
import com.dfth2020.repository.ProductionStepRepository;
import com.dfth2020.server.api.OrderApi;
import com.dfth2020.server.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

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
    public ResponseEntity<Order> createOrder(@Valid CreateOrder createOrder) {
        OrderEntity orderEntity = OrderGenerator.generateOrder(createOrder);

        OrderEntity createdOrderEntity = orderRepository.save(orderEntity);

        Order order = mapOrderEntityToOrder(createdOrderEntity);

        return ResponseEntity.ok(order);
    }

    @Override
    public ResponseEntity<Orders> getOrders() {
        List<OrderEntity> orderEntities = orderRepository.findAll();

        List<Order> orderList = orderEntities.stream().map(this::mapOrderEntityToOrder).collect(toList());

        Orders orders = OrderMapper.mapOrders(orderList);

        return ResponseEntity.ok(orders);
    }

    private Order mapOrderEntityToOrder(OrderEntity orderEntity) {
        List<OrderItem> orderItems = orderEntity.getOrderItems().stream().map(orderItem -> {
            List<ProductionStep> productionSteps = orderItem.getProductionSteps().stream().map(ProductionStepMapper::mapProductionStep).collect(toList());
            return OrderItemMapper.mapOrderItem(orderItem, productionSteps);
        }).collect(toList());

        return OrderMapper.mapOrder(orderEntity, orderItems);
    }

    @Override
    public ResponseEntity<Order> getOrder(UUID orderId) {
        Optional<OrderEntity> maybeOrderEntity = orderRepository.findById(orderId);

        if (maybeOrderEntity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        OrderEntity orderEntity = maybeOrderEntity.get();

        List<OrderItem> orderItems = orderEntity.getOrderItems().stream().map(orderItem -> {
            List<ProductionStep> productionSteps = orderItem.getProductionSteps().stream().map(ProductionStepMapper::mapProductionStep).collect(toList());
            return OrderItemMapper.mapOrderItem(orderItem, productionSteps);
        }).collect(toList());

        Order order = OrderMapper.mapOrder(orderEntity, orderItems);

        return ResponseEntity.ok(order);
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
