package com.example.performance.domain.settlement.repository;

import com.example.performance.domain.settlement.document.Settlement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementRepository extends MongoRepository<Settlement, Long> {
}
