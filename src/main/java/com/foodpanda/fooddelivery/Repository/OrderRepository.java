package com.foodpanda.fooddelivery.Repository;

import com.foodpanda.fooddelivery.Entity.Order;
import com.foodpanda.fooddelivery.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID> {
    // A user can place multiple orders
    List<Order> findByUser(User user);

    // Multiple orders are usually placed on one day
    List<Order> findByDateOrdered(LocalDateTime dateOrdered);
}
