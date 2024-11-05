package com.to.ordermanagementservice.service;

import com.to.ordermanagementservice.dto.OrderDetails;

import java.util.List;

public interface OrderService {

    List<OrderDetails> getAllOrders();

}
