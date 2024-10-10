package com.to.ordermanagementservice.utils;

import com.to.ordermanagementservice.dto.OrderItemDetails;

import java.math.BigDecimal;
import java.util.List;

public final class TotalPriceCalculator {
    private TotalPriceCalculator() {
    }

    public static BigDecimal getTotalPriceForOrder(List<OrderItemDetails> orderItems) {
        BigDecimal result = BigDecimal.ZERO;
        if (orderItems == null || orderItems.isEmpty()) {
            return result;
        }
        for (OrderItemDetails orderItem : orderItems) {
            BigDecimal totalPrice = orderItem.getProduct().getPrice()
                    .multiply(BigDecimal.valueOf(orderItem.getQuantity()));
            result = result.add(totalPrice);
        }
        return result;
    }
}
