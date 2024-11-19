package com.to.ordermanagementservice.web.controller;

import com.to.ordermanagementservice.dto.OrderDetails;
import com.to.ordermanagementservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrdersApiController {

    private final OrderService orderService;

    public OrdersApiController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDetails>> apiV1OrdersGet() {
        var orders = orderService.getAllOrders();
        return CollectionUtils.isEmpty(orders)
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(orders);

    }

    @GetMapping("/orders/{orderID}")
    public ResponseEntity<OrderDetails> getOrderByID(@PathVariable int orderID) {
        return orderService.getOrderByID(orderID).map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
