package com.example.messagequeue.producer;

import com.example.messagequeue.queue.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MessageSendTest {

    @Autowired
    MessageProducer messageProducer;

    @Test
    @DisplayName("메세지를 보내면 성공 응답이 온다.")
    void sendMessageOne() {

        // given
        Message massage = new Message("1", "테스트용 메세지 입니다.");

        // when / then
        assertThat(messageProducer.sendOne(massage)).isEqualTo(true);

    }

}
