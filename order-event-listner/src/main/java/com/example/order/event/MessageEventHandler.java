package com.example.order.event;

import com.example.order.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageEventHandler {

    private final MessageService messageService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void sendOrderCompleteMessage(MessageEvent event) throws InterruptedException {
        String message = "[" +
                event.orderId() +
                "] " +
                event.orderName() +
                "의 주문이 완료되었습니다.";
        messageService.sendMessage(message);
        log.info("success message sent!!");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void sendOrderFailMessage(MessageEvent event) throws InterruptedException {
        String message = "[" +
                event.orderId() +
                "] " +
                event.orderName() +
                "의 주문이 완료 실패하였습니다.";
        messageService.sendMessage(message);
        log.info("fail message sent!!");
    }

}
