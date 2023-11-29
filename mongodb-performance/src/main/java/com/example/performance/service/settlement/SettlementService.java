package com.example.performance.service.settlement;

import com.example.performance.domain.settlement.document.Settlement;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.*;
import com.mongodb.client.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

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
                            .append("_id", settlement.getId())
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
                            .append("_id", settlement.getId())
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
        MongoDatabase database = mongoClient.getDatabase("performance");
        MongoCollection<Document> collection = database.getCollection("settlement");

        Document document = new Document()
                .append("$set", new Document("orderName", "updateMany"));

        long startTime = System.currentTimeMillis();
        collection.updateMany(Filters.eq("status", "WAITING"), document);
        long endTime = System.currentTimeMillis();
        long takenTime = (endTime - startTime);

        log.info("startTime    : {}", startTime);
        log.info("endTime      : {}", endTime);
        log.info("takenTime(ms): {}", takenTime);
    }

    public void bulkWrite() {

        MongoDatabase database = mongoClient.getDatabase("performance");
        MongoCollection<Document> collection = database.getCollection("settlement");
        List<WriteModel<Document>> settlementList = new ArrayList<>();

        for (Document document : collection.find()) {
            settlementList.add(
                    new UpdateOneModel<>(new Document("_id", document.get("_id")),
                            new Document("$set", new Document("orderName", "bulkWrite")),
                            new UpdateOptions().upsert(true))
            );
        }

        long startTime = System.currentTimeMillis();
        collection.bulkWrite(settlementList);
        long endTime = System.currentTimeMillis();
        long takenTime = (endTime - startTime);

        log.info("startTime    : {}", startTime);
        log.info("endTime      : {}", endTime);
        log.info("takenTime(ms): {}", takenTime);

    }

}
