package com.example.api.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RedisRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public Long increment() {
        return redisTemplate.opsForValue()
                .increment("coupon:FCFS:count");
    }

    public Long set(String key) {
        return redisTemplate.opsForSet()
                .add("applied_user", key);
    }

}
