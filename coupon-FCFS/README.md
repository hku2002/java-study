## 선착순 쿠폰 발급 시스템

 - 선착순(First Come First Served) 100명에게 할인 쿠폰을 제공하는 샘플 코드
 - 수많은 트래픽이 몰리더라도 100명에게만 할인 쿠폰이 발급되도록 하는 선착순 시스템 연습 코드

### 요구사항
1. 선착순 100명에게만 지급되어야 한다.
2. 101개 이상이 지급되어서는 안된다.
3. 순간적으로 몰리는 트래픽을 버텨야 한다.
4. user 1명당 1개의 쿠폰만 발급해야 한다.

### 사용하는 시스템

- mysql
- Redis
- Kafka

### Mysql 명령어
```shell
# docker의 mysql 진입
docker exec -it mysql bash

# mysql 진입 및 database 생성
mysql -u root -p
1234

create database coupon;
use coupon;
```

### Redis 명령어
```shell
# docker의 redis-cli 진입
docker exec -it redis redis-cli

# incr 사용법
incr {key}

# key 모두 삭제
flushall
```

### kafka 명령어
```shell
# docker의 kafka 진입
docker exec -it kafka /bin/bash

# 토픽생성
kafka-topics.sh --bootstrap-server localhost:9092 --create --topic coupon-FCFS

# 프로듀서 실행
kafka-console-producer.sh --topic coupon-FCFS --broker-list 0.0.0.0:9092

# 컨슈머 실행
kafka-console-consumer.sh --topic coupon-FCFS --bootstrap-server localhost:9092
```
