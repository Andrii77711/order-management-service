package com.to.ordermanagementservice.service.impl;

import com.to.ordermanagementservice.dto.OrderDetails;
import com.to.ordermanagementservice.dto.OrderItemDetails;
import com.to.ordermanagementservice.dto.ProductDetails;
import com.to.ordermanagementservice.entity.Order;
import com.to.ordermanagementservice.mapper.OrderItemMapper;
import com.to.ordermanagementservice.mapper.OrderMapper;
import com.to.ordermanagementservice.mapper.ProductMapper;
import com.to.ordermanagementservice.repository.OrderItemRepository;
import com.to.ordermanagementservice.repository.OrderRepository;
import com.to.ordermanagementservice.repository.ProductRepository;
import com.to.ordermanagementservice.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.to.ordermanagementservice.utils.TotalPriceCalculator.getTotalPriceForOrder;

@Service
public class SimpleOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;
    private final ProductMapper productMapper;

    public SimpleOrderService(OrderRepository orderRepository,
                              OrderItemRepository orderItemRepository,
                              ProductRepository productRepository,
                              OrderMapper orderMapper,
                              OrderItemMapper orderItemMapper,
                              ProductMapper productMapper) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
        this.orderMapper = orderMapper;
        this.orderItemMapper = orderItemMapper;
        this.productMapper = productMapper;
    }

    @Override
    public List<OrderDetails> getAllOrders() {
        List<Order> orders = orderRepository.getAllOrders();

        List<OrderDetails> list = new ArrayList<>(orders.size());
        for (Order order : orders) {
            OrderDetails orderDetails = orderMapper.toOrderDetails(order);
            orderDetails.setTotalPrice(getTotalPriceForOrder(orderDetails.getOrderItems()));
            orderDetails.setOrderItems(collectOrderItemDetails(order.getId()));
            list.add(orderDetails);
        }
        return list;
    }

    private List<OrderItemDetails> collectOrderItemDetails(Integer orderId) {
        return orderItemRepository.getOrderItemsByOrderId(orderId).stream()
                .map(orderItem -> orderItemMapper.toOrderItemDetails(orderItem,
                        getProductById(orderItem.getProductId())))
                .toList();
    }

    private ProductDetails getProductById(int id) {
        return productMapper.toProductDetails(productRepository.getProductById(id));
    }

}
