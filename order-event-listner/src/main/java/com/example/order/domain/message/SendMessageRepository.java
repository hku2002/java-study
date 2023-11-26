package com.example.order.domain.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendMessageRepository extends JpaRepository<SendMessage, Long> {
}
