package com.example.order.service.product;

import com.example.order.domain.product.Product;
import com.example.order.domain.product.ProductRepository;
import com.example.order.domain.stock.Stock;
import com.example.order.domain.stock.StockRepository;
import com.example.order.service.product.dto.ProductResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.order.domain.product.enumtype.ProductStatus.ON_SALE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    StockRepository stockRepository;

    @BeforeEach
    void beforeEach() {
        productRepository.deleteAll();
    }

    @Test
    @DisplayName("상품 1개 조회 시 dto 값에 올바르게 응답주어야 한다.")
    void getProductSuccessTest() {
        // given
        Stock stock = Stock.builder()
                .stockName("재고명1")
                .quantity(10)
                .build();
        stockRepository.saveAndFlush(stock);
        Product product = Product.builder()
                .productName("상품명1")
                .price(10_000)
                .status(ON_SALE)
                .stock(stock)
                .build();
        productRepository.saveAndFlush(product);

        // when
        ProductResponse productResponse = productService.getProduct(product.getId());

        // then
        assertThat(productResponse).isNotNull();

    }

    @Test
    @DisplayName("상품 정보가 없을 경우 예외가 발생해야 한다.")
    void emptyProductExceptionTest() {
        // given
        Stock stock = Stock.builder()
                .stockName("재고명1")
                .quantity(10)
                .build();
        stockRepository.saveAndFlush(stock);
        Product product = Product.builder()
                .productName("상품명1")
                .price(10_000)
                .status(ON_SALE)
                .stock(stock)
                .build();
        productRepository.save(product);

        // when, then
        assertThatThrownBy(() -> productService.getProduct(10000L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품 정보가 없습니다.");
    }

}