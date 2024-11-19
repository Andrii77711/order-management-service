package com.to.ordermanagementservice.service;

import com.to.ordermanagementservice.dto.OrderDetails;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<OrderDetails> getAllOrders();
    Optional<OrderDetails> getOrderByID(int id);

}
