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

    public void sendMessage(String message) throws InterruptedException {
        SendMessage sendMessage = SendMessage.builder()
                .status(MessageStatus.READY)
                .message(message)
                .build();
//        throw new InterruptedException();
        sendMessageRepository.save(sendMessage);
    }
}
