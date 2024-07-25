package com.to.ordermanagementservice.service.impl;

import com.to.ordermanagementservice.dto.OrderDetails;
import com.to.ordermanagementservice.dto.OrderItemDetails;
import com.to.ordermanagementservice.dto.ProductDetails;
import com.to.ordermanagementservice.entity.Order;
import com.to.ordermanagementservice.entity.OrderItem;
import com.to.ordermanagementservice.entity.Product;
import com.to.ordermanagementservice.repository.OrderItemRepository;
import com.to.ordermanagementservice.repository.OrderRepository;
import com.to.ordermanagementservice.repository.ProductRepository;
import com.to.ordermanagementservice.service.OrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    public SimpleOrderService(OrderRepository orderRepository,
                              OrderItemRepository orderItemRepository,
                              ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
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
        orderDetails.setTotalPrice(getTotalPriceForOrder(orderDetails.getOrderItems()));
        return orderDetails;
    }

    private BigDecimal getTotalPriceForOrder(List<OrderItemDetails> orderItems) {
        BigDecimal result = BigDecimal.ZERO;
        for (OrderItemDetails orderItem : orderItems) {
            BigDecimal totalPrice = orderItem.getProduct().getPrice()
                    .multiply(BigDecimal.valueOf(orderItem.getQuantity()));
            result = result.add(totalPrice);
        }
        return result;
    }

    private List<OrderItemDetails> collectOrderItemDetails(Integer orderId) {
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
        orderItemDetails.setProduct(getProductById(orderItem.getProductId()));
        orderItemDetails.setQuantity(orderItem.getQuantity());
        return orderItemDetails;
    }

    private ProductDetails getProductById(int id) {
        return convertProductToProductDetails(productRepository.getProductById(id));
    }

    private ProductDetails convertProductToProductDetails(Product product) {
        ProductDetails productDetails = new ProductDetails();
        productDetails.setId(product.getId());
        productDetails.setName(product.getName());
        productDetails.setPrice(product.getPrice());
        productDetails.setDescription(product.description());
        return productDetails;
    }
}
