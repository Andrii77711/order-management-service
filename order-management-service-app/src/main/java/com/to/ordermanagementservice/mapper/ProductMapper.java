package com.to.ordermanagementservice.mapper;

import com.to.ordermanagementservice.dto.ProductDetails;
import com.to.ordermanagementservice.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDetails toProductDetails(Product product) {
        ProductDetails productDetails = new ProductDetails();
        productDetails.setId(product.getId());
        productDetails.setName(product.getName());
        productDetails.setPrice(product.getPrice());
        productDetails.setDescription(product.description());
        return productDetails;
    }
}
