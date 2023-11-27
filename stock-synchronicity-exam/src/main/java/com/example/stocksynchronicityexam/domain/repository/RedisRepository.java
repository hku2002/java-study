package com.example.stocksynchronicityexam.domain.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedisRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public Boolean lock(String key, String value) {
        return redisTemplate.opsForValue()
                .setIfAbsent(key, value, Duration.ofSeconds(2));
    }

    public Boolean lock(Long key, String value) {
        return lock(String.valueOf(key), value);
    }

    public Boolean unlock(String key) {
        return redisTemplate.delete(key);
    }

    public Boolean unlock(Long key) {
        return unlock(String.valueOf(key));
    }

}
