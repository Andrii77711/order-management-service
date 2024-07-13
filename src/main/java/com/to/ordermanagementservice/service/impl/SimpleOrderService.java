package com.to.ordermanagementservice.service.impl;

import com.to.ordermanagementservice.dto.OrderDetails;
import com.to.ordermanagementservice.dto.OrderItemDetails;
import com.to.ordermanagementservice.entity.Order;
import com.to.ordermanagementservice.entity.OrderItem;
import com.to.ordermanagementservice.repository.OrderItemRepository;
import com.to.ordermanagementservice.repository.OrderRepository;
import com.to.ordermanagementservice.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public SimpleOrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
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
        orderDetails.setId(order.getId());
        orderDetails.setOrderItems(collectOrderItemDetails(order.getId()));
        orderDetails.setCustomerId(order.getUserId());
        orderDetails.setUpdatedAt(order.getUpdatedAt());
        orderDetails.setCreatedAt(order.getCreatedAt());
        return orderDetails;
    }
    private List<OrderItemDetails> collectOrderItemDetails (Integer orderId){
        return orderItemRepository.getOrderItemsByOrderId(orderId).stream()
                .map(orderItem -> convertOrderItemToOrderItemDetails(orderItem))
                .toList();
    }

    private OrderItemDetails convertOrderItemToOrderItemDetails(OrderItem orderItem) {
        OrderItemDetails orderItemDetails = new OrderItemDetails();
        orderItemDetails.setId(orderItem.getId());
        orderItemDetails.setOrderId(orderItem.getOrderId());
        orderItemDetails.setUpdatedAt(orderItem.getUpdatedAt());
        orderItemDetails.setCreatedAt(orderItem.getCreatedAt());
        orderItemDetails.setPrice(orderItem.getPrice());
        orderItemDetails.setQuantity(orderItem.getQuantity());
        orderItemDetails.setProductId(orderItem.getProductId());
        return orderItemDetails;
    }
}
