package com.dfth2020.repository;

import com.dfth2020.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, UUID> {

    @Query("SELECT oI FROM order_item oI WHERE oI.orderId=:orderId")
    List<OrderItemEntity> findAllByOrderId(UUID orderId);

    @Query("SELECT oI FROM order_item oI WHERE oI.orderId=:orderId AND oI.id=:orderItemId")
    Optional<OrderItemEntity> findByIdAndOrderItemId(UUID orderId, UUID orderItemId);
}
