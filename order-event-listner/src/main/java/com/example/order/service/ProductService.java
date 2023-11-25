package com.example.order.service;

import com.example.order.domain.product.Product;
import com.example.order.domain.product.ProductRepository;
import com.example.order.service.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("상품 정보가 없습니다."));
        return ProductResponse.from(product);
    }

}
