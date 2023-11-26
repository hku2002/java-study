package com.example.order.event;

import com.example.order.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageEventHandler {

    private final MessageService messageService;

    @EventListener
    public void sendOrderCompleteMessage(MessageEvent event) {
        log.info("event : {}", event);
        log.info("message sent!!");
    }

}
