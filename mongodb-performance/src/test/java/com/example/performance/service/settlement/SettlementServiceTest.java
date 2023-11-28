package com.example.performance.service.settlement;

import com.example.performance.domain.settlement.document.Settlement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.performance.domain.settlement.enumtype.SettlementStatus.WAITING;

@SpringBootTest
class SettlementServiceTest {

    @Autowired
    SettlementService settlementService;

    @Test
    @DisplayName("insertManyTest")
    void insertManyTest() {
        List<Settlement> settlements = new ArrayList<>();
        for (int i=0; i<300000; i++) {
            settlements.add(
                Settlement.builder()
                        .orderName("주문" + i)
                        .status(WAITING)
                        .totalPrice(1000)
                        .createdAt(LocalDateTime.now())
                        .build()
            );
        }

        settlementService.insertMany(settlements);
    }

}