package com.example.performance.service.settlement;

import com.example.performance.domain.settlement.document.Settlement;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SettlementService {

    private final MongoClient mongoClient;

    public void insertOne(List<Settlement> settlements) {
        MongoDatabase database = mongoClient.getDatabase("performance");
        MongoCollection<Document> collection = database.getCollection("settlement");
        long startTime = System.currentTimeMillis();
        for (Settlement settlement : settlements) {
            collection.insertOne(
                    new Document()
                            .append("orderName", settlement.getOrderName())
                            .append("status", settlement.getStatus())
                            .append("totalPrice", settlement.getTotalPrice())
                            .append("createdAt", settlement.getCreatedAt())
            );
        }
        long endTime = System.currentTimeMillis();
        long takenTime = (endTime - startTime) / 1000;

        log.info("startTime    : {}", startTime);
        log.info("endTime      : {}", endTime);
        log.info("takenTime(ms): {}", takenTime);
    }
    public void insertMany(List<Settlement> settlements) {

        MongoDatabase database = mongoClient.getDatabase("performance");
        List<Document> settlementList = new ArrayList<>();
        for (Settlement settlement : settlements) {
            settlementList.add(
                    new Document()
                            .append("orderName", settlement.getOrderName())
                            .append("status", settlement.getStatus())
                            .append("totalPrice", settlement.getTotalPrice())
                            .append("createdAt", settlement.getCreatedAt())
            );
        }
        MongoCollection<Document> collection = database.getCollection("settlement");
        long startTime = System.currentTimeMillis();
        collection.insertMany(settlementList);
        long endTime = System.currentTimeMillis();
        long takenTime = (endTime - startTime);

        log.info("startTime    : {}", startTime);
        log.info("endTime      : {}", endTime);
        log.info("takenTime(ms): {}", takenTime);
    }

    public void updateOne() {

    }

    public void updateMany() {

    }

    public void bulkWrite() {

    }

}
