package com.to.ordermanagementservice.service.impl;

import com.to.ordermanagementservice.dto.OrderDetails;
import com.to.ordermanagementservice.entity.Order;
import com.to.ordermanagementservice.repository.OrderRepository;
import com.to.ordermanagementservice.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleOrderService implements OrderService {

    private final OrderRepository orderRepository;

    public SimpleOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDetails> getAllOrders() {
        List<Order> orders = orderRepository.getAllOrders();

        List<OrderDetails> list = new ArrayList<>(orders.size());
        for (Order order : orders) {
            OrderDetails orderDetails = collectOrderDetails(order);
            list.add(orderDetails);
        }
        return list;
    }


    private OrderDetails collectOrderDetails(Order order) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderId(order.getId());
        return orderDetails;
    }

}
