package com.to.ordermanagementservice.service.impl;

import com.to.ordermanagementservice.dto.OrderDetails;
import com.to.ordermanagementservice.dto.OrderItemDetails;
import com.to.ordermanagementservice.dto.ProductDetails;
import com.to.ordermanagementservice.entity.Order;
import com.to.ordermanagementservice.entity.OrderItem;
import com.to.ordermanagementservice.entity.Product;
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
import java.util.Map;

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
            list.add(collectOrderDetails(order));
        }
        return list;
    }

    private OrderDetails collectOrderDetails(Order order) {
        OrderDetails orderDetails = orderMapper.toOrderDetails(order);
        orderDetails.setOrderItems(collectOrderItemDetails(order.getId()));
        orderDetails.setTotalPrice(getTotalPriceForOrder(orderDetails.getOrderItems()));
        return orderDetails;
    }

    private List<OrderItemDetails> collectOrderItemDetails(Integer orderId) {
        List<OrderItem> orderItemsByOrderId = orderItemRepository.getOrderItemsByOrderId(orderId);
        List<Integer> productIds = orderItemsByOrderId.stream().map(OrderItem::getProductId).toList();
        Map<Integer, Product> productsByIds = productRepository.getProductsByIds(productIds);
        return orderItemsByOrderId.stream().map(orderItem -> {
            ProductDetails pd = productMapper.toProductDetails(productsByIds.get(orderItem.getProductId()));
            return orderItemMapper.toOrderItemDetails(orderItem, pd);
        }).toList();
    }

}
