package com.example.order.service.message;

import com.example.order.domain.message.SendMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final SendMessageRepository sendMessageRepository;

    public void sendOrderCompleteMessage(Long orderId) {

    }
}
