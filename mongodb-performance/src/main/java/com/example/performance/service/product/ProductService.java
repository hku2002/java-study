package com.example.performance.service.product;

import com.example.performance.domain.product.document.Product;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOneModel;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.WriteModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final MongoClient mongoClient;

    public void insertOne(List<Product> products) {
        MongoDatabase database = mongoClient.getDatabase("performance");
        MongoCollection<Document> collection = database.getCollection("product");
        long startTime = System.currentTimeMillis();
        for (Product product : products) {
            collection.insertOne(
                    new Document()
                            .append("_id", product.getId())
                            .append("productName", product.getProductName())
                            .append("price", product.getPrice())
                            .append("discountPrice", product.getDiscountPrice())
                            .append("discountType", product.getDiscountType())
                            .append("category1Id", product.getCategory1Id())
                            .append("category2Id", product.getCategory2Id())
                            .append("category3Id", product.getCategory3Id())
                            .append("category4Id", product.getCategory4Id())
                            .append("status", product.getStatus())
                            .append("ThumbnailImageUrl", product.getThumbnailImageUrl())
                            .append("detailImageUrl", product.getDetailImageUrl())
                            .append("explainImageUrl", product.getExplainImageUrl())
                            .append("badgeImageUrl", product.getBadgeImageUrl())
                            .append("videoUrl", product.getVideoUrl())
                            .append("stockId", product.getStockId())
                            .append("stockName", product.getStockName())
                            .append("option1Id", product.getOption1Id())
                            .append("option1Name", product.getOption1Name())
                            .append("option2Id", product.getOption2Id())
                            .append("option2Name", product.getOption2Name())
                            .append("isPackage", product.isPackage())
                            .append("isSample", product.isSample())
                            .append("activated", product.isActivated())
                            .append("workerId", product.getWorkerId())
                            .append("workerName", product.getWorkerName())
                            .append("eventStartedAt", product.getEventStartedAt())
                            .append("eventEndedAt", product.getEventEndedAt())
                            .append("createdAt", product.getCreatedAt())
                            .append("updatedAt", product.getUpdatedAt())
            );
        }
        long endTime = System.currentTimeMillis();
        long takenTime = (endTime - startTime);

        log.info("startTime    : {}", startTime);
        log.info("endTime      : {}", endTime);
        log.info("takenTime(ms): {}", takenTime);
    }

    public void insertMany(List<Product> products) {
        MongoDatabase database = mongoClient.getDatabase("performance");
        MongoCollection<Document> collection = database.getCollection("product");
        long startTime = System.currentTimeMillis();

        List<Document> productList = new ArrayList<>();

        for (Product product : products) {
            productList.add(
                    new Document()
                            .append("_id", product.getId())
                            .append("productName", product.getProductName())
                            .append("price", product.getPrice())
                            .append("discountPrice", product.getDiscountPrice())
                            .append("discountType", product.getDiscountType())
                            .append("category1Id", product.getCategory1Id())
                            .append("category2Id", product.getCategory2Id())
                            .append("category3Id", product.getCategory3Id())
                            .append("category4Id", product.getCategory4Id())
                            .append("status", product.getStatus())
                            .append("ThumbnailImageUrl", product.getThumbnailImageUrl())
                            .append("detailImageUrl", product.getDetailImageUrl())
                            .append("explainImageUrl", product.getExplainImageUrl())
                            .append("badgeImageUrl", product.getBadgeImageUrl())
                            .append("videoUrl", product.getVideoUrl())
                            .append("stockId", product.getStockId())
                            .append("stockName", product.getStockName())
                            .append("option1Id", product.getOption1Id())
                            .append("option1Name", product.getOption1Name())
                            .append("option2Id", product.getOption2Id())
                            .append("option2Name", product.getOption2Name())
                            .append("isPackage", product.isPackage())
                            .append("isSample", product.isSample())
                            .append("activated", product.isActivated())
                            .append("workerId", product.getWorkerId())
                            .append("workerName", product.getWorkerName())
                            .append("eventStartedAt", product.getEventStartedAt())
                            .append("eventEndedAt", product.getEventEndedAt())
                            .append("createdAt", product.getCreatedAt())
                            .append("updatedAt", product.getUpdatedAt())
            );

        }

        collection.insertMany(productList);

        long endTime = System.currentTimeMillis();
        long takenTime = (endTime - startTime);

        log.info("startTime    : {}", startTime);
        log.info("endTime      : {}", endTime);
        log.info("takenTime(ms): {}", takenTime);
    }

    public void bulkWrite() {
        MongoDatabase database = mongoClient.getDatabase("performance");
        MongoCollection<Document> collection = database.getCollection("product");
        List<WriteModel<Document>> productList = new ArrayList<>();

        for (Document document : collection.find()) {
            productList.add(
                    new UpdateOneModel<>(new Document("_id", document.get("_id")),
                            new Document("$set", new Document("productName", "bulkWrite")),
                            new UpdateOptions().upsert(true))
            );
        }

        long startTime = System.currentTimeMillis();
        collection.bulkWrite(productList);
        long endTime = System.currentTimeMillis();
        long takenTime = (endTime - startTime);

        log.info("startTime    : {}", startTime);
        log.info("endTime      : {}", endTime);
        log.info("takenTime(ms): {}", takenTime);
    }
}
