package com.example.order.service.order;

import com.example.order.domain.order.Order;
import com.example.order.domain.order.OrderProduct;
import com.example.order.domain.order.OrderRepository;
import com.example.order.domain.product.Product;
import com.example.order.domain.product.ProductRepository;
import com.example.order.domain.stock.Stock;
import com.example.order.domain.stock.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final StockRepository stockRepository;

    @Transactional
    public void completeOrder(Long id) {
        // 주문 정보 조회
        Order order = orderRepository.findByIdWithOrderProducts(id)
                .orElseThrow(() -> new IllegalArgumentException("주문 정보가 존재하지 않습니다."));

        // 상품 가격 조회
        List<Long> productIds = order.getOrderProducts().stream()
                .map(OrderProduct::getProductId)
                .toList();
        List<Product> products = productRepository.findByIdIn(productIds);

        // 상품 가격 validation
        int productsTotalPrice = products.stream()
                .mapToInt(Product::getPrice)
                .sum();
        if (order.getTotalPrice() != productsTotalPrice) {
            throw new IllegalArgumentException("가격 정보가 올바르지 않습니다.");
        }

        // 재고 정보 조회
        List<Long> stockIds = products.stream()
                .map(product -> product.getStock().getId())
                .toList();
        List<Stock> stocks = stockRepository.findByIdIn(stockIds);

        // 재고 차감
        stocks.forEach(stock -> stock.deductQuantity(1));

        // 주문 완료
        order.completeStatus();

        // 메세지 이벤트 전송


    }
}
