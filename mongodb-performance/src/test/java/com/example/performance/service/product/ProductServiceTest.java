package com.example.performance.service.product;

import com.example.performance.domain.product.document.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    void insertOneTest() {
        List<Product> products = new ArrayList<>();
        for (int i=0; i<100000; i++) {
            products.add(
                    Product.builder()
                            .id((long) i)
                            .productName("상품명" + i)
                            .price(1000 + i)
                            .discountPrice(800 + i)
                            .category1Id(1L)
                            .category2Id(2L)
                            .category3Id(3L)
                            .category4Id(4L)
                            .status("SELL")
                            .thumbnailImageUrl("https://images.sample.com/thumbnail" + i)
                            .detailImageUrl("https://images.sample.com/detail" + i)
                            .explainImageUrl("https://images.sample.com/explain" + i)
                            .badgeImageUrl("https://images.sample.com/badge" + i)
                            .videoUrl("https://images.sample.com/video" + i)
                            .stockId((long) i)
                            .stockName("재고" + i)
                            .option1Id(1L)
                            .option1Name("옵션 첫번째")
                            .option2Id(2L)
                            .option2Name("옵션 두번재")
                            .isPackage(false)
                            .isPackage(false)
                            .activated(true)
                            .workerId(1L)
                            .workerName("작업자명")
                            .eventStartedAt(LocalDateTime.now().minusHours(3L))
                            .eventEndedAt(LocalDateTime.now().plusHours(3L))
                            .createdAt(LocalDateTime.now())
                            .build()
            );
        }

        productService.insertOne(products);

    }

    @Test
    void insertManyTest() {
        List<Product> products = new ArrayList<>();
        for (int i=0; i<100000; i++) {
            products.add(
                    Product.builder()
                            .id((long) i)
                            .productName("상품명" + i)
                            .price(1000 + i)
                            .discountPrice(800 + i)
                            .category1Id(1L)
                            .category2Id(2L)
                            .category3Id(3L)
                            .category4Id(4L)
                            .status("SELL")
                            .thumbnailImageUrl("https://images.sample.com/thumbnail" + i)
                            .detailImageUrl("https://images.sample.com/detail" + i)
                            .explainImageUrl("https://images.sample.com/explain" + i)
                            .badgeImageUrl("https://images.sample.com/badge" + i)
                            .videoUrl("https://images.sample.com/video" + i)
                            .stockId((long) i)
                            .stockName("재고" + i)
                            .option1Id(1L)
                            .option1Name("옵션 첫번째")
                            .option2Id(2L)
                            .option2Name("옵션 두번재")
                            .isPackage(false)
                            .isPackage(false)
                            .activated(true)
                            .workerId(1L)
                            .workerName("작업자명")
                            .eventStartedAt(LocalDateTime.now().minusHours(3L))
                            .eventEndedAt(LocalDateTime.now().plusHours(3L))
                            .createdAt(LocalDateTime.now())
                            .build()
            );
        }

        productService.insertMany(products);

    }
}
