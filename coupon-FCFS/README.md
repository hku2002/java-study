## 선착순 쿠폰 발급 시스템

 - 선착순 100명에게 할일 쿠폰을 제공하는 샘플 코드

### 요구사항
1. 선착순 100명에게만 지급되어야 한다.
2. 101개 이상이 지급되어서는 안된다.
3. 순간적으로 몰리는 트래픽을 버텨야 한다.

### 사용하는 시스템

- Redis
- Kafka

### Redis 명령어
```shell
# docker의 redis-cli 진입
docker exec -it my-redis redis-cli

# incr 사용법
incr {key}

# key 모두 삭제
flushall
```

