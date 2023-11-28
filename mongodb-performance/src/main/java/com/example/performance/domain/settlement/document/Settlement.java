package com.example.performance.domain.settlement.document;

import com.example.performance.domain.settlement.enumtype.SettlementStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Document
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Settlement {

    @Id
    private ObjectId id;
    private String orderName;
    private String totalPrice;
    private SettlementStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Settlement(String orderName, String totalPrice, SettlementStatus status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.orderName = orderName;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
