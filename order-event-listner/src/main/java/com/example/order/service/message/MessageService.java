package com.example.order.service.message;

import com.example.order.domain.message.SendMessage;
import com.example.order.domain.message.SendMessageRepository;
import com.example.order.domain.message.enumtype.MessageStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final SendMessageRepository sendMessageRepository;

    public void sendOrderCompleteMessage(Long orderId) {
        SendMessage sendMessage = SendMessage.builder()
                .status(MessageStatus.READY)
                .message(orderId + "주문이 완료되었습니다.")
                .build();
        sendMessageRepository.save(sendMessage);
    }
}
