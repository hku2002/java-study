package com.example.stocksynchronicityexam.service;

import com.example.stocksynchronicityexam.domain.entity.Stock;
import com.example.stocksynchronicityexam.domain.repository.RedisRepository;
import com.example.stocksynchronicityexam.domain.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;
    private final RedisRepository repository;
    private final RedissonClient redissonClient;

    public synchronized void decrease(Long id, int quantity) {
        Stock stock = stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);
        stockRepository.save(stock);
    }

    @Transactional
    public void pessimisticDecrease(Long id, int quantity) {
        Stock stock = stockRepository.findByIdWithPessimisticLock(id);
        stock.decrease(quantity);
        stockRepository.save(stock);
    }

    @Transactional
    public void optimisticDecrease(Long id, int quantity) {
        Stock stock = stockRepository.findByIdWithOptimisticLock(id);
        stock.decrease(quantity);
        stockRepository.save(stock);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void namedLockDecrease(Long id, int quantity) {
        Stock stock = stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);
        stockRepository.save(stock);
    }

    @Transactional
    public void redisSetnxDecrease(Long id, int quantity) throws InterruptedException {
        while (!repository.lock(id, "stock:quantity:lock")) {
            Thread.sleep(100);
        }
        Stock stock = stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);
        stockRepository.save(stock);
        repository.unlock(stock.getId());
    }

    @Transactional
    public void redisPubSubDecrease(Long id, int quantity) throws InterruptedException {
        RLock lock = redissonClient.getLock(String.valueOf(id));
        boolean isRocked = lock.tryLock(15, 1, TimeUnit.SECONDS);
        if (!isRocked) {
            log.warn("lock 획득 실패");
            return;
        }
        Stock stock = stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);
        try {
            stockRepository.save(stock);
        } finally {
            lock.unlock();
        }
        log.info("@@@@@@@@@@@@ test");

    }

}
