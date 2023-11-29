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
    @DisplayName("insertOneTest")
    void insertOneTest() {
        List<Settlement> settlements = new ArrayList<>();
        for (int i=0; i<100000; i++) {
            settlements.add(
                    Settlement.builder()
                            .id((long) i)
                            .orderName("주문" + i)
                            .status(WAITING)
                            .totalPrice(1000)
                            .createdAt(LocalDateTime.now())
                            .build()
            );
        }

        settlementService.insertOne(settlements);
        // 100,000건 약 13초 소요
    }

    @Test
    @DisplayName("insertOneTreadSleepTest")
    void insertOneTreadSleepTest() throws InterruptedException {
        List<Settlement> settlements = new ArrayList<>();
        for (int i=0; i<100000; i++) {
            settlements.add(
                    Settlement.builder()
                            .id((long) i)
                            .orderName("주문" + i)
                            .status(WAITING)
                            .totalPrice(1000)
                            .createdAt(LocalDateTime.now())
                            .build()
            );
        }

        settlementService.insertOneThreadSleep(settlements);
    }

    @Test
    @DisplayName("insertManyTest")
    void insertManyTest() {
        List<Settlement> settlements = new ArrayList<>();
        for (int i=0; i<100000; i++) {
            settlements.add(
                Settlement.builder()
                        .id((long) i)
                        .orderName("주문" + i)
                        .status(WAITING)
                        .totalPrice(1000)
                        .createdAt(LocalDateTime.now())
                        .build()
            );
        }

        settlementService.insertMany(settlements);
        // 100,000건 약 633ms 소요
    }

    @Test
    @DisplayName("updateOneTest")
    void updateOneTest() {
        settlementService.updateOne();
        // 100,000건 약 14초 소요
    }

    @Test
    @DisplayName("updateManyTest")
    void updateManyTest() {
        settlementService.updateMany();
        // 100,000건 약 495ms 소요
    }

    @Test
    @DisplayName("bulkWriteTest")
    void bulkWriteTest() {
        settlementService.bulkWrite();
        // 100,000건 약 1480ms 소요
    }

}
