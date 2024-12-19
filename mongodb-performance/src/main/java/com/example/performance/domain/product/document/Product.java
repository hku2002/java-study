package com.example.performance.domain.product.document;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Document
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    private Long id;
    private String productName;
    private int price;
    private int discountPrice;
    private String discountType;
    private Long category1Id;
    private Long category2Id;
    private Long category3Id;
    private Long category4Id;
    private String status;
    private String ThumbnailImageUrl;
    private String detailImageUrl;
    private String explainImageUrl;
    private String badgeImageUrl;
    private String videoUrl;
    private Long stockId;
    private String stockName;
    private Long option1Id;
    private String option1Name;
    private Long option2Id;
    private String option2Name;
    private Coupon coupon;
    private boolean isPackage;
    private boolean isSample;
    private boolean activated;
    private Long workerId;
    private String workerName;
    private LocalDateTime eventStartedAt;
    private LocalDateTime eventEndedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Product(Long id, String productName, int price, int discountPrice, String discountType, Long category1Id, Long category2Id, Long category3Id, Long category4Id, String status, String thumbnailImageUrl, String detailImageUrl, String explainImageUrl, String badgeImageUrl, String videoUrl, Long stockId, String stockName, Long option1Id, String option1Name, Long option2Id, String option2Name, Coupon coupon, boolean isPackage, boolean isSample, boolean activated, Long workerId, String workerName, LocalDateTime eventStartedAt, LocalDateTime eventEndedAt, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.discountPrice = discountPrice;
        this.discountType = discountType;
        this.category1Id = category1Id;
        this.category2Id = category2Id;
        this.category3Id = category3Id;
        this.category4Id = category4Id;
        this.status = status;
        ThumbnailImageUrl = thumbnailImageUrl;
        this.detailImageUrl = detailImageUrl;
        this.explainImageUrl = explainImageUrl;
        this.badgeImageUrl = badgeImageUrl;
        this.videoUrl = videoUrl;
        this.stockId = stockId;
        this.stockName = stockName;
        this.option1Id = option1Id;
        this.option1Name = option1Name;
        this.option2Id = option2Id;
        this.option2Name = option2Name;
        this.coupon = coupon;
        this.isPackage = isPackage;
        this.isSample = isSample;
        this.activated = activated;
        this.workerId = workerId;
        this.workerName = workerName;
        this.eventStartedAt = eventStartedAt;
        this.eventEndedAt = eventEndedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
